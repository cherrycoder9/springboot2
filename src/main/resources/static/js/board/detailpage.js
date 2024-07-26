// src\main\resources\static\js\board\detailpage.js
console.log('detailpage.js');

function displayBoardDetail(response) {
    const board = response.board;
    const boardDetail = document.querySelector('#boardDetail');

    let fileHtml = '첨부파일: 없음';
    if (board.bfile) {
        const originalFileName = board.bfile.split('_').slice(1).join('_'); // UUID 제거하고 파일명만 추출
        fileHtml = `첨부파일: <a href="#" id="fileLink" data-filename="${board.bfile}">${originalFileName}</a>`;
    }

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
            <p>${fileHtml}</p>
        </div>
    `;

    if (board.bfile) {
        const fileLink = document.getElementById('fileLink');
        fileLink.addEventListener('click', (e) => {
            e.preventDefault();
            downloadFile(board.bfile);
        });
    }
}

function downloadFile(filename) {
    console.log('downloadFile()', filename);

    // 파일 다운로드를 위한 URL 생성
    const url = `/files/${filename}`;
    console.log('다운로드 URL:', url);

    // 파일 다운로드를 위한 Ajax 요청
    $.ajax({
        method: 'GET',
        url: url,
        xhrFields: {
            responseType: 'blob' // 파일을 바이너리 형식으로 받기 위해 설정
        },
        success: function (data, status, xhr) {
            // 응답 데이터가 Blob 타입으로 오므로 이를 처리합니다.
            const blob = new Blob([data], {type: xhr.getResponseHeader('Content-Type')});
            const downloadUrl = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = downloadUrl;
            a.download = filename; // 다운로드 될 파일 이름 설정
            document.body.appendChild(a);
            a.click();
            window.URL.revokeObjectURL(downloadUrl); // URL 해제
            console.log('파일 다운로드 성공');
        },
        error: function (xhr, status, error) {
            console.error('파일 다운로드 오류:', xhr, status, error);
            alert('파일 다운로드 중 오류가 발생했습니다.');
        }
    });
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
            data: JSON.stringify({bno}),
            contentType: "application/json",
            success: (result) => {
                if (result) {
                    alert('게시물이 삭제되었습니다.');
                    window.location.href = '/board/allpage';
                } else {
                    alert('삭제에 실패했습니다.');
                }
            },
            error: (error) => {
                console.error('삭제오류:', error);
                alert('삭제 중 오류가 발생했습니다.');
            }
        });
    }
}

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
        },
        error: (error) => {
            console.error('게시물 로드 오류:', error);
        }
    });
}
