console.log("mypage.js");

mypage();

function mypage() {
    console.log("mypage()");
    let no = document.querySelector('#no');
    let id = document.querySelector('#id');
    let name = document.querySelector('#name');
    let email = document.querySelector('#email');
    let phone = document.querySelector('#phone');
    $.ajax({
        async: true,
        method: "get",
        url: "/member/myinfo",
        success: function (data) {
            console.log(data);
            if (data.length == 0) {
                location.href = "/member/login";
            } else {
                no.innerHTML = data.no;
                id.innerHTML = data.id;
                name.innerHTML = data.name;
                email.innerHTML = data.email;
                phone.innerHTML = data.phone;
            }
        }
    });
}

function doModify() {
    console.log("doModify()");
    location.href = "/member/modify";
}

function doWithdraw() {
    console.log("doWithdraw()");
    location.href = "/member/withdraw";
}