// src\main\resources\static\js\board\update.js
console.log('update.js');
document.addEventListener('DOMContentLoaded', (event) => {
    loadBoardData();
});

function loadBoardData() {
    console.log('loadBoardData()');
    // URL에서 bno 파라미터 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    const bno = urlParams.get('bno');

    // 게시물 상세 정보 가져오기
    $.ajax({
        method: 'GET',
        url: `/board/detail?bno=${bno}`,
        contentType: "application/json",
        success: (data) => {
            const board = data.board;
            document.getElementById('bno').value = board.bno;
            document.getElementById('btitle').value = board.btitle;
            document.getElementById('bcontent').value = board.bcontent;
            document.getElementById('bcno').value = board.bcno;
        }
    });
}

function updatePost() {
    console.log('updatePost()');
    const bno = document.getElementById('bno').value;
    const btitle = document.getElementById('btitle').value;
    const bcontent = document.getElementById('bcontent').value;
    const bcno = document.getElementById('bcno').value;

    $.ajax({
        method: 'PUT',
        url: '/board/update',
        contentType: "application/json",
        data: JSON.stringify({
            bno: bno,
            btitle: btitle,
            bcontent: bcontent,
            bcno: bcno
        }),
        success: (result) => {
            if (result) {
                alert('게시물이 수정되었습니다.');
                window.location.href = `/board/detailpage?bno=${bno}`;
            } else {
                alert('수정에 실패했습니다.');
            }
        },
    });
}
