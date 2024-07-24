console.log('login.js');

// 로그인 
function doLogin() {
    console.log("doLogin()");
    let mId = document.querySelector('#id').value;
    let mPw = document.querySelector('#pw').value;

    $.ajax({
        async: false,
        method: "post",
        url: "/member/login",
        data: {
            id: mId,
            pw: mPw,
        },
        success: function (resp) {
            if (resp) {
                alert("로그인 성공");
                console.log(resp);
                location.href = "/";
            } else {
                alert("로그인 실패");
            }
        }
    });
}