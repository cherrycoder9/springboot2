console.log('write.js');

// write.html 페이지가 열리면 바로 실행할 함수 

// 카테고리를 불러옴
$.ajax({
    method: 'get',
    url: '/board/category',
    success: function (result) {
        // 받아오는데 성공하면 각 카테고리의 이름을 select box의 option으로 하나씩 추가 
        if (result != '') {
            console.log(result);
            for (let i = 0; i < result.length; i++) {
                $('#selectbox').append('<option value="' + result[i].bcno + '">' + result[i].bcname + '</option>');
            }
        } else {
            alert('오류 발생');
        }
    }
});


// 글쓰고 등록 버튼을 누르면 실행할 버튼의 함수
// DB에 글 내용을 저장함
function doWrite() {
    console.log('doWrite()');

    let btitle = $('#btitle').val();
    let bcontent = $('#bcontent').val();
    let bcno = $('#selectbox').val();

    $.ajax({
        method: 'post',
        url: '/board/write',
        data: {btitle, bcontent, bcno},
        success: function (result) {
            if (result) {
                alert('글쓰기 성공');
                location.href = '/board/allpage';
            } else {
                alert('글쓰기 실패');
            }
        }
    });
}
