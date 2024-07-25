// src\main\resources\static\js\board\detailpage.js
console.log('detailpage.js');

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
    console.log(response);
    const board = response.board;
    const loggedInUserId = response.loggedInUserId;
    const fileName = board.bfile ? board.bfile.split('_')[1] : '없음'; // UUID 제거하고 파일명만 추출

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
        <div>
            <p>첨부파일: <a href="/upload/${board.bfile}" target="_blank">${fileName}</a></p>
        </div>
    `;

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
    console.log('editPost()');
    window.location.href = `/board/update?bno=${bno}`;
}

function deletePost(bno) {
    console.log('deletePost()');
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
