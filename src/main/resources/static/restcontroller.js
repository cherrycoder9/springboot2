console.log("restcontroller.js");

// rest3get
function rest3get() {
    console.log("rest3get");
    let option = {
        method: 'get', // 통신할 HTTP 메소드 선택 
        url: "/example/rest3?key=qwe", // 통신할 URL, 스프링의 컨트롤러 매핑 주소 
        success: function (response) {
            console.log(response);
        }
    };
    $.ajax(option);

}

// rest3post
function rest3post() {
    console.log("rest3post");
    $.ajax({
        method: "post", // HTTP 메소드 
        url: "/example/rest3?key=qwe", // HTTP 통신할 경로 URL, 컨트롤러 매핑 
        success: function (response) { // HTTP 성공응답, 컨트롤러가 리턴한 값 
            console.log(response);
        }
    }); // ajax end
} // method end 

// rest3put
function rest3put() {
    let value = document.querySelector("#value").value;

    console.log("rest3put");
    $.ajax({
        method: "put", // HTTP 메소드
        url: "/example/rest3", // HTTP 통신할 경로 URL, 컨트롤러 매핑
        data: { "key": value },
        success: function (response) { // HTTP 성공응답, 컨트롤러가 리턴한 값
            console.log(response);
        }
    }); // ajax end
}

// rest3delete
function rest3delete() {
    let value = document.querySelector("#value").value;

    console.log("rest3delete");
    $.ajax({
        method: "delete", // HTTP 메소드
        url: "/example/rest3", // HTTP 통신할 경로 URL, 컨트롤러 매핑
        data: { "key": value },
        success: function (response) { // HTTP 성공응답, 컨트롤러가 리턴한 값
            console.log(response);
        }
    }); // ajax end
}