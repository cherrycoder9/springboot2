document.addEventListener('DOMContentLoaded', (event) => {
    loadBoardDetail();
});

function loadBoardDetail() {
    console.log('loadBoardDetail()');
    // URL에서 bno 파라미터 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    const bno = urlParams.get('bno');

    // 게시물 상세 정보 가져오기
    $.ajax({
        method: 'GET',
        url: `/board/detail?bno=${bno}`,
        contentType: "application/json",
        success: (data) => {
            displayBoardDetail(data);
        }
    });
}

function displayBoardDetail(board) {
    console.log('displayBoardDetail()');
    const boardDetail = document.querySelector('#boardDetail');
    boardDetail.innerHTML = `
        <h2>${board.btitle}</h2>
        <p>카테고리: ${board.bcname}</p>
        <p>작성자: ${board.id}</p>
        <p>작성일: ${board.bdate}</p>
        <p>조회수: ${board.bview}</p>
        <div>
            <p>${board.bcontent}</p>
        </div>
    `;
}

function editPost() {
    console.log('editPost()');
    const urlParams = new URLSearchParams(window.location.search);
    const bno = urlParams.get('bno');
    window.location.href = `/board/update?bno=${bno}`;
}

function deletePost(bno) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        $.ajax({
            method: 'DELETE',
            url: `/board/delete`,
            data: { "bno": bno },
            contentType: "application/json",
            success: (result) => {
                if (result) {
                    alert('게시물이 삭제되었습니다.');
                    window.location.href = '/board/all';
                } else {
                    alert('삭제에 실패했습니다.');
                }
            }
        });
    }
}

