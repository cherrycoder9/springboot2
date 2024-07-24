doCategory();
function doCategory() {
    $.ajax({

        method: 'get',
        url: "/board/category",
        contentType: "application/json",
        success: result => {

            if (result == '') {
                alert('잘못된 방식입니다.');
            }

            //어디에
            let cateBox = document.querySelector('#cateBox');

            //무엇을
            let html = '';
            html += `<div> ${result.bcno} </div>`;
            html += `<div> ${result.bcname} </div>`;

            //출력
            cateBox.innerHTML = html;
        } //success end
    });//ajax end
}//doCategory end