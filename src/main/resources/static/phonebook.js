console.log("phonebook.js 열림");
// let phonebookDB = []

// 1. 등록함수: 등록버튼을 클릭했을때
function postPhone() {
    // 1. 입력받고
    let name = document.querySelector('#name').value;
    let phone = document.querySelector('#phone').value;

    // 2. 객체화
    let phoneDto = {
        name: name,
        phone: phone,
    }

    // 2. html에 jquery 라이브러리 가져왔으면 ajax 함수 사용 가능
    // 2-1. ajax 들어갈 옵션 객체 정의
    let option = {
        url: "http://localhost:8080/phone/create", // 통신할 경로
        method: "POST", // HTTP가 지원하는 함수중 사용할 함수명(post, get, put, delete)
        data: JSON.stringify(phoneDto), // 통신할 경로에 보낼 데이터 --> spring의 controller에게 보낼 데이터
        contentType: "application/json", // data 옵션에 있는 타입
        success: function reponse(result) {
            console.log(result); // JSON.parse(result)를 해야하지만 스프링이 알아서 해줌
            if (result) {
                alert('saved');
                getPhone();
            } else {
                alert('fail');
            } // response 함수 end
        } // 통신을 성공했을때 응답받을 함수
    }

    // 2-2. ajax 함수 호출
    $.ajax(option);

    // 3. 객체를 배열에 저장
    // phonebookDB.push(phoneDto);

    // 4. 안내 / 새로고침
    // alert("Phone added successfully.");
    // getPhone();
}

getPhone();

// 2. 출력함수: 등록처리가 되었을때, js열렸을때 최초 1번
function getPhone() {
    // 1. 어디에
    let phoneListBox = document.querySelector('#phoneListBox');
    let html = '';

    let option = {
        url: "http://localhost:8080/phone/read", // 누구에게
        method: "GET", // 어떤 방식으로
        // data: , // 무엇을 보내고 (없음)
        success: function reponse(result) { // 무엇을 받을지
            console.log(result)
            // 2. 무엇을
            result.forEach(phone => {
                html += `<div>
                    <span>${phone.name}</span>
                    <span>${phone.phone}</span>
                </div>`;
            });

            // 3. 출력
            phoneListBox.innerHTML = html;
        }
    }; // ajax 통신 option 설정 end

    // ajax 실행 함수
    $.ajax(option);


}