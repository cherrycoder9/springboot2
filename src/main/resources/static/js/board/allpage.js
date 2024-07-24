doBoard();
function doBoard() {
    console.log('doBoard');

    $.ajax({
        method: 'get',
        url: '/board/all',
        contentType: "application/json",

        success: result => {
            console.log(result);
            if (result) {
                //어디에
                let boardBox = document.querySelector('#boardBox');

                //무엇을
                let html = '';
                html += `<div> ${result.bno} </div> `;
                html += `<div> ${result.btitle} </div> `;
                html += `<div> ${result.no} </div> `;
                html += `<div> ${result.bdate} </div> `;
                html += `<div> ${result.bview} </div> `;
                console.log(result.bno);
                console.log(result.btitle);
                console.log(result.no);
                console.log(result.bdate);
                console.log(result.bview);

                //게시물번호, 제목,작성자(id),작성일,조회수
                boardBox.innerHTML = html;
                console.log(boardBox);
            } else {
                console.log('test1');
                alert('잘못된 방식입니다.');
            }
            console.log('test2');

        }//success end
    });//ajax end
} //doBoard end