doBoard();
function doBoard() {
    console.log('doBoard');

    // 게시물 목록 조회
    $.ajax({
        /*
        public class BoardDto {
            private long bno ;          // 번호
            private String btitle;      // 제목
            private String bcontent;        // 내용
            private String bfile;       // 첨부파일
            private long bview ;        // 조회수
            private String bdate;       // 작성일
            // 카테고리
            private long bcno ;         // 카테고리 번호
            private String bcname ;         // 카테고리 이름
            // 회원
            private long no ;          // 작성자 번호
            private String id;          // 작성자 아이디
        }
        */
        method: 'get',
        url: '/board/all',
        contentType: "application/json",

        success: result => {
            // 글 목록 배열을 반환받으면 출력 
            console.log(result);

            //어디에
            let boardBox = document.querySelector('#boardBox');
            let html = '';

            // 출력사항: 게시물 번호, 제목, 작성자(id), 작성일, 조회수
            for (let i = 0; i < result.length; i++) {
                html += `<div> ${result[i].bno} </div>`;
                html += `<div> ${result[i].btitle} </div>`;
                html += `<div> ${result[i].id} </div>`;
                html += `<div> ${result[i].bdate} </div>`;
                html += `<div> ${result[i].bview} </div>`;
            }
            boardBox.innerHTML = html;
            console.log('test4');
        }//success end
    });//ajax end
} //doBoard end


// 글쓰기 버튼
function writePost() {
    console.log('writePost()');
}