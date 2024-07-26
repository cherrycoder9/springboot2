// src\main\resources\static\js\member\login.js

console.log('login.js');

document.addEventListener('DOMContentLoaded', () => {
    checkLoginStatus();
});

function checkLoginStatus() {
    $.ajax({
        method: 'GET',
        url: '/member/login/status',
        success: function (isLoggedIn) {
            if (isLoggedIn) {
                alert("이미 로그인되어 있습니다.");
                window.location.href = '/';
            }
        }
    });
}


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