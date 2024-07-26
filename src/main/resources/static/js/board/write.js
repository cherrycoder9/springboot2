// src\main\resources\static\js\board\write.js

console.log('write.js');

// 페이지 로드 시 카테고리 목록 가져오기
document.addEventListener('DOMContentLoaded', () => {
    loadCategories();
});

function loadCategories() {
    $.ajax({
        method: 'GET',
        url: '/board/category',
        success: (data) => {
            let selectBox = document.querySelector('#selectbox');
            selectBox.innerHTML = ''; // 기존 옵션 삭제
            data.forEach(category => {
                let option = document.createElement('option');
                option.value = category.bcno;
                option.text = category.bcname;
                selectBox.appendChild(option);
            });
        }
    });
}

// 글 작성 요청
function doWrite() {
    const formData = new FormData();
    formData.append("btitle", document.querySelector('#btitle').value);
    formData.append("bcontent", document.querySelector('#bcontent').value);
    formData.append("bcno", document.querySelector('#selectbox').value);

    const fileInput = document.querySelector('#bfile');
    if (fileInput.files.length > 0) {
        formData.append("bfile", fileInput.files[0]);
    }

    $.ajax({
        method: 'POST',
        url: '/board/write',
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            if (response) {
                alert('글 작성이 완료되었습니다.');
                window.location.href = '/board/allpage';
            } else {
                alert('글 작성에 실패했습니다.');
            }
        }
    });
}

