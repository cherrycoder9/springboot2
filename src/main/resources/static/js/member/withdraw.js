console.log("withdraw.js");

function withdrawConfirm() {
    /*
    <form>
        비밀번호 입력 : <input id="pw" type="password" /><br>
    </form> <br>
    <button type="button" onclick="withdrawConfirm()">수정</button>
    */
    console.log("withdrawConfirm()");
    let pw = document.querySelector('#pw');
    if (pw.value == "") {
        alert("비밀번호를 입력해주세요.");
        pw.focus();
        return;
    }
    $.ajax({
        async: true,
        method: "delete",
        url: "/member/withdraw",
        data: {
            pw: pw.value
        },
        success: function (result) {
            console.log(result);
            if (result) {
                alert("회원 탈퇴가 완료되었습니다.");
                location.href = "/";
            } else {
                alert("비밀번호가 일치하지 않습니다.");
                pw.focus();
            }
        }
    });
}