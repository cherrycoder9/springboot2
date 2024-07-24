console.log('signup.js');

// 2. 아이디 유효성 검사
function idCheck() {
    console.log("idCheck()");
    // 1. 입력된 값 가져오기 
    let id = document.querySelector('#id').value;
    let idCheckBox = document.querySelector('#idCheckBox');
    console.log(id);
    // 2. 정규표현식 생성
    // 특정한 규칙을 가진 문자열의 집합을 표현할 때 사용하는 형식 언어 
    // 주로 문자열 데이터 검사할 때 사용된다. - 유효성 검사
    // JS의 검사 메소드 
    // 정규표현식.text(검사할대상)
    // 형식 규칙
    // /^ : 지ㅓㅇ규표현식 시작 알림
    // $/ : 정규표현식 끝 알림 
    // a : 문자 a 1개
    // [a-z] : 소문자 a~z 사이의 문자 1개
    // [a-zA-Z] : 소문자 a~z, 대문자 A~Z 사이의 문자 1개
    // [a-zA-Z0-9] : 소문자 a~z, 대문자 A~Z, 숫자 0~9 사이의 문자 1개
    // [가-힣] : 한글 1개
    // + : 1개 이상
    // [ac] : a 또는 c 중 하나
    // [^ac] : a 또는 c가 아닌 문자 1개
    // {n} : n개
    // {n,m} : n개 이상 m개 이하
    // {n,} : n개 이상
    // {,m} : m개 이하
    let idReg = /^[a-zA-Z0-9]{5,30}$/;
    // 3. 정규표현식 검사
    console.log(`글자제한: ${idReg.test(id)}`); // true/false
    let duplicate = false;
    if (idReg.test(id)) {
        // 아이디 중복 검사 RestAPI
        $.ajax({
            async: false,
            method: "get",
            url: "/member/idcheck",
            data: {
                "id": id
            },
            success: function (result) {
                console.log(`아이디 중복: ${result}`);
                if (result) {
                    duplicate = false;
                } else {
                    duplicate = true;
                }
            }
        });

        if (duplicate) {
            console.log("아이디 중복");
            idCheckBox.innerHTML = "중복된 아이디입니다.";
            checkArray[0] = false;
            return;
        } else {
            console.log("아이디 적합");
            idCheckBox.innerHTML = "사용 가능한 아이디입니다.";
            checkArray[0] = true;
            return;
        }

    } else {
        console.log("아이디 부적합");
        idCheckBox.innerHTML = "알파벳 대소문자와 숫자 조합의 5~30글자로 입력해주세요.";
        checkArray[0] = false;
        return;
    }
}

// 3. 비밀번호 유효성 검사
function pwCheck() {
    // 1.
    console.log("pwCheck()");
    let pw = document.querySelector('#pw').value;
    let pwConfirm = document.querySelector('#pwConfirm').value;
    let pwCheckBox = document.querySelector('#pwCheckBox');
    console.log(pw);
    // 2. 정규표현식 생성
    let pwReg = /^[a-zA-Z0-9]{5,30}$/;
    // 3. 정규표현식 검사
    if (pwReg.test(pw)) {
        if (pw === pwConfirm) {
            console.log("비밀번호 적합");
            pwCheckBox.innerHTML = "비밀번호가 일치합니다.";
            checkArray[1] = true;
            return;
        } else {
            console.log("비밀번호 부적합");
            pwCheckBox.innerHTML = "비밀번호가 일치하지 않습니다.";
            checkArray[1] = false;
            return;
        }
    }
}

// 전화번호 유효성 검사
function phoneCheck() {
    console.log("phoneCheck()");
    let phone = document.querySelector('#phone').value;
    let phoneCheckBox = document.querySelector('#phoneCheckBox');
    let phoneReg = /^([0-9]{2,3})+[-]([0-9]{3,4})+[-]([0-9]{4})$/;
    if (phoneReg.test(phone)) {
        console.log("전화번호 적합");
        phoneCheckBox.innerHTML = "전화번호가 적합합니다.";
        checkArray[4] = true;
    } else {
        console.log("전화번호 부적합");
        phoneCheckBox.innerHTML = "전화번호가 적합하지 않습니다.";
        checkArray[4] = false;
    }
}

let authBtn = document.querySelector('#authBtn'); // 이메일 인증 버튼
let interval = null; // 타이머 인터벌 변수

// 이메일 인증 버튼 클릭시 실행할 함수
function doAuth() {
    console.log("doAuth()");
    // AJAX 인증 번호 요청 통신
    $.ajax({
        async: false, // 동기식 
        method: "get", // 요청 방식
        url: "/auth/code", // 요청 URL
        // 입력받은 이메일을 전송 
        data: {
            "email": document.querySelector('#email').value
        },
        success: (result) => {
            if (result) {
                alert("인증 번호가 전송되었습니다.");
            }
        }
    });


    authBtn.disabled = true;

    // 인증 번호 입력 구역 구성
    let html = `
        <span id="timerDisplay">01:40</span>
        <input type="text" id="authCodeInput" />
        <button type="button" id="verifyBtn" onclick="doAuthCode()">인증</button>
    `;
    // authBox 내부 HTML 구성
    let authBox = document.getElementById('authBox');
    authBox.innerHTML = html;

    // 타이머 
    let timer = 100; // 타이머 시간 (초)
    // 인터벌 생성 (JS라이브러리): 특정 주기에 따라 함수를 실행함
    interval = setInterval(() => {
        // 분, 초 계산
        let m = parseInt(timer / 60);
        let s = timer % 60;
        // 두자리수로 표현 
        if (m < 10) {
            m = "0" + m;
        }
        if (s < 10) {
            s = "0" + s;
        }
        // 타이머 시간 감소
        timer--;
        console.log(timer);
        // 타이머 시간 출력
        let span = document.getElementById('timerDisplay');
        span.innerHTML = `${m}:${s}`;
        // 타이머 종료
        if (timer < 0) {
            clearInterval(interval);
            // 인증버튼 비활성화
            let verifyBtn = document.getElementById('verifyBtn');
            verifyBtn.disabled = true;
            authBox.innerHTML = "인증 시간이 초과되었습니다.";
            authBtn.disabled = false;
            checkArray[3] = false;
        }
    }, 1000);
}

// 인증코드 인증 
function doAuthCode() {
    // 입력한 입력번호 가져오기 
    let authCodeInput = document.getElementById('authCodeInput').value;
    // 인증번호 비교
    // 임의의 인증번호 (JS에서 인증번호를 관리하지 않는 이유: JS는 클라이언트로부터 오픈된 코드이기 때문에)
    // let authCodeRandom = "123456";
    // // 만약에 입력한 값이 인증번호와 동일하면
    // if (authCode == authCodeRandom) {
    //     // 인증버튼 비활성화
    //     let verifyBtn = document.getElementById('verifyBtn');
    //     verifyBtn.disabled = true;
    //     // 인증버튼 삭제
    //     authBox.innerHTML = "인증되었습니다.";
    //     // 타이머 종료
    //     clearInterval(interval);
    //     // 인증버튼 활성화
    //     authBtn.disabled = false;
    // } else {
    //     alert("인증번호 불일치");
    //     // 인증버튼 비활성화
    //     let verifyBtn = document.getElementById('verifyBtn');
    //     verifyBtn.disabled = true;
    // }
    // 위 코드들은 보안에 취약하므로 자바백엔드에서 API 통신 처리해야 함.
    // 인증 번호 요청 구현
    // 1. AuthController 에서 인증 번호 요청 구현
    // GET, /auth/code 
    // 줘야할 매개변수: x
    // 받아야할 매개변수: 성공/실패 여부 
    // 2. AuthService 에서 인증 번호 요청 구현
    // 숫자 형식의 난수 6자리 생성
    // 인증 번호 인증 구현 
    // 3. AuthController 에서 인증 번호 인증 구현
    // POST, /auth/check
    // 줘야할 매개변수: authCodeInput
    // 받아야할 매개변수: true는 인증 성공, false는 인증 실패
    // 4. AuthService 에서 인증 번호 인증 구현
    // 요청시 생성된 인증번호의 비교 

    // AJAX 통신 
    $.ajax({
        async: false, // 동기식
        method: "post", // 요청 방식
        url: "/auth/check", // 요청 URL
        data: {
            authCodeInput: authCodeInput
        },
        success: (result) => {
            if (result) {
                // 인증버튼 비활성화
                let verifyBtn = document.getElementById('verifyBtn');
                verifyBtn.disabled = true;
                // 인증버튼 삭제
                authBox.innerHTML = "인증되었습니다.";
                checkArray[3] = true;
                // 타이머 종료
                clearInterval(interval);
                // 인증버튼 활성화
                authBtn.disabled = false;

            } else {
                if (authCodeInput == "") {
                    alert("인증번호를 입력하세요.");
                } else {
                    alert("인증번호가 불일치합니다.");
                    checkArray[3] = false;
                }
            }
        }
    });
}

// 이메일 유효성 검사 
function emailCheck() {
    console.log("emailCheck()");
    // 인증버튼 비활성화
    authBtn.disabled = true;
    let email = document.querySelector('#email').value;
    let emailCheckBox = document.querySelector('#emailCheckBox');
    let emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (emailReg.test(email)) {
        console.log("이메일 적합");
        emailCheckBox.innerHTML = "이메일이 적합합니다.";
        // 이메일 인증검사
        // 인증버튼 활성화 
        authBtn.disabled = false;
        return;
    } else {
        console.log("이메일 부적합");
        emailCheckBox.innerHTML = "이메일이 적합하지 않습니다.";
        return;
    }
}

// 아이디, 비밀번호, 이름, 이메일인증, 전화번호 유효성검사 체크 현황
let checkArray = [false, false, true, false, false];

// 회원가입
function doSignup() {
    // 유효성 검사 체크
    if (checkArray[0] == false) {
        alert("아이디를 입력하세요.");
        return;
    }
    if (checkArray[1] == false) {
        alert("비밀번호를 입력하세요.");
        return;
    }
    if (checkArray[2] == false) {
        alert("이름을 입력하세요.");
        return;
    }
    if (checkArray[3] == false) {
        alert("이메일을 인증하세요.");
        return;
    }
    if (checkArray[4] == false) {
        alert("전화번호를 입력하세요.");
        return;
    }

    console.log("doSignup()");
    let mId = document.querySelector('#id').value;
    let mPw = document.querySelector('#pw').value;
    let mName = document.querySelector('#name').value;
    let mEmail = document.querySelector('#email').value;
    let mPhone = document.querySelector('#phone').value;

    $.ajax({
        async: false,
        method: "post",
        url: "/member/signup",
        data: {
            id: mId,
            pw: mPw,
            name: mName,
            email: mEmail,
            phone: mPhone
        },
        success: function (resp) {
            if (resp) {
                alert("회원가입 성공");
                location.href = "/member/login";
            } else {
                alert("회원가입 실패");
            }
        }
    });
}