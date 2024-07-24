console.log("modify.js");

/* <form>
    새 이름: <input id="name" type="text" /><br>
        새 비밀번호 : <input id="pw" type="password" /><br>
            비밀번호 확인: <input id="pwConfirm" type="password" /><br>
                새 연락처: <input id="phone" type="text" /><br>
                </form> <br>
                    <button type="button" onclick="modifyConfirm()">수정</button>; */

function modifyConfirm() {
    console.log("modifyConfirm()");
    let name = document.querySelector('#name');
    let pw = document.querySelector('#pw');
    let pwConfirm = document.querySelector('#pwConfirm');
    let phone = document.querySelector('#phone');

    if (name.value == "") {
        alert("이름을 입력해주세요.");
        name.focus();
        return;
    }
    if (pw.value == "") {
        alert("비밀번호를 입력해주세요.");
        pw.focus();
        return;
    }
    if (pwConfirm.value == "") {
        alert("비밀번호를 확인해주세요.");
        pwConfirm.focus();
        return;
    }
    if (phone.value == "") {
        alert("연락처를 입력해주세요.");
        phone.focus();
        return;
    }

    if (pw.value != pwConfirm.value) {
        alert("비밀번호가 일치하지 않습니다.");
        pw.focus();
        return;
    }

    $.ajax({
        async: true,
        method: "put",
        url: "/member/modify",
        data: {
            name: name.value,
            pw: pw.value,
            phone: phone.value
        },
        success: function (result) {
            console.log(result);
            if (result) {
                alert("수정되었습니다.");
                location.href = "/member/mypage";
            } else {
                alert("수정에 실패하였습니다.");
            }
        }
    });
}