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

            // 게시물이 표시될 컨테이너
            let boardBox = document.querySelector('#boardBox');
            let html = `<table border="1">
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>`;

            // 게시물 정보 출력
            result.forEach(board => {
                html += `<tr>
                            <td>${board.bno}</td>
                            <td><a href="/board/detailpage?bno=${board.bno}">${board.btitle}</a></td>
                            <td>${board.id}</td>
                            <td>${board.bdate}</td>
                            <td>${board.bview}</td>
                         </tr>`;
            });

            html += `</table>`;
            boardBox.innerHTML = html;
        } // success end
    }); // ajax end
} // doBoard end


// 글쓰기 버튼
function writePost() {
    console.log('writePost()');
    // 글쓰기 페이지로 이동 
    location.href = "./write";

}