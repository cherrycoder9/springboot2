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

function displayBoardDetail(response) {
    console.log(response); // 응답 데이터 구조 확인
    const board = response.board;
    const loggedInUserId = response.loggedInUserId;

    const boardDetail = document.querySelector('#boardDetail');
    boardDetail.innerHTML = `
        <h2>${board.btitle}</h2>
        <p>카테고리: ${board.bcname || '알 수 없음'}</p>
        <p>작성자: ${board.id || '알 수 없음'}</p>
        <p>작성일: ${board.bdate}</p>
        <p>조회수: ${board.bview}</p>
        <div>
            <p>${board.bcontent}</p>
        </div>
    `;

    // 작성자와 로그인된 사용자가 동일한 경우에만 수정 및 삭제 버튼 표시
    if (board.id === loggedInUserId) {
        boardDetail.innerHTML += `
            <div id="editDeleteButtons">
                <button onclick="editPost(${board.bno})">수정</button>
                <button onclick="deletePost(${board.bno})">삭제</button>
            </div>
        `;
    }
}

function editPost(bno) {
    window.location.href = `/board/update?bno=${bno}`;
}

function deletePost(bno) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        $.ajax({
            method: 'DELETE',
            url: `/board/delete`,
            data: JSON.stringify({bno: bno}),
            contentType: "application/json",
            success: (result) => {
                if (result) {
                    alert('게시물이 삭제되었습니다.');
                    window.location.href = '/board/allpage';
                } else {
                    alert('삭제에 실패했습니다.');
                }
            },
        });
    }
}


