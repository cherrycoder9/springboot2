console.log('category.js');
doCategory();

function doCategory() {
    console.log('doCategory');
    $.ajax({

        method: 'get',
        url: "/board/category",
        contentType: "application/json",
        success: result => {
            console.log(result);
            console.log('test1');
            if (result == '') {
                alert('잘못된 방식입니다.');
                console.log('test2');
            }

            //어디에
            let cateBox = document.querySelector('#cateBox');
            console.log(result.bcno);
            console.log(result.bcname);

            //무엇을
            let html = '';
            html += `<div> ${result.bcno} </div>`;
            html += `<div> ${result.bcname} </div>`;

            //출력
            // cateBox.innerHTML = html;
            console.log('test4');
        } //success end
    });//ajax end
}//doCategory end
