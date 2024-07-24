/*

  요구사항 확인
    [ 비회원 게시판 ]
    1. 글 등록 하는데 비회원제 이면서 제목 과 내용 과 비밀번호 입력 해주세요.
    2. 모든 글 출력하는데 날짜 , 제목 , 조회수 순으로 출력해주세요.
    3. 모든 글에서 제목을 클릭하면 상세 글 이 출력되고 모든 정보 출력 될수 있도록 해주세요.
      <날짜 , 제목 , 조회수 , 내용 >
    4. 상세 글에서 수정시 비밀번호를 입력받아 일치할 경우에만 새로운 내용을 입력받고 수정해주세요.
    5. 상세 글에서 삭제시 비밀번호를 입력받아 일치할 경우에만 삭제

  -요구사항 분석 -> 설계
    [ 백엔드 ]
    1.메모리 구성
      1. 등록용:제목 , 내용 , 비밀번호
      2. 출력용:날짜 , 조회수
      - 1안(배열) :  배열 5개
        1. title = [ title1, title2 , title3 ] ,
          content = [ content1 ,content2,content3 ] ,
          password = [ password1 , password2 , password3] ,
          date = [ date1 , date2 , date3 ] ,
          view = [ view1 , view2 , view3 ]

        2. boardList = [
              [ title1,content1,password1,date1 ] ,
              [ title2,content2,password2,date2 ] ,
              [ title3,content3,password3,date3 ]
            ]

      - 2안(문자열)
          boardList = [ "title1,content1,password1,date1" , "title2,content2,password2,date2" , "title3,content3,password3,date3" ]
            - " " 하나의 문자열이 하나의 게시물이 되고 , 쉼표 기준으로 게시물의 정보 구분한다.
          boardList = "title1,content1,password1,date1\ntitle2,content2,password2,date2\ntitle3,content3,password3,date3"
            - 전체 게시물을 " " 하고 각 게시물은 \n 구분하고 , 쉼표는 각 게시물의 정보를 분류한다.

      - 3안(객체)
    2.기능 구성
      1. 등록 create( )
      2. 모든글출력 allRead( )
      3. 상세글출력 read( )
      4. 수정 update( )
      5. 삭제 delete( )
    3.기능 마다의 로직 순서도
      1. create( ) : 1. HTML에서 입력받은 값 가져오기 2.유효성검사 3.배열 저장 4. 안내
      2. allRead( ) : 1. (어디에)출력할html요소호출 2. (무엇을)반복문 이용한 배열내 데이터를 HTML형식 구성 3.(출력/대입) 구성한html를 요소에 대입
      3. read( )    : 1. 상세정보의 인덱스를 받고 2. 해당 인덱스의 정보를 출력한다( 어디에 무엇을 출력 )
      4. update( ) : 1. 업데이트할 인덱스를 받고 2. 비밀번호를 새롭게 입력받아 3. 입력받은 비밀번호와 해당 인덱스의 비밀번호와 일치하면 4. 해당 인덱스 수정
      5. delete() : 1. 삭제할 인덱스를 받고 2. 비밀번호를 새롭게 입력받아 3. 입력받은 비밀번호와 해당 인덱스의 비밀번호와 일치하면 4. 해당 인덱스 삭제
    [ 프론트엔드 ]
    1. HTML 구성

  개발/구현
    [ 각 파트별 구현 ]
    [ 연동 ]
  테스트

  유지보수
*/

// let boardList = [
//     "제목입니다,내용입니다,1234,2024-05-24,3" ,
//     "두번째제목이야,또내용입니다,4567,2024-05-25,0"
//   ];


// 1. 등록함수 실행조건 : 1.등록버튼을 클릭했을때
function _create() {


    let title = document.querySelector('#titleInput').value;
    let content = document.querySelector('#contentInput').value;
    let password = document.querySelector('#passwordInput').value;

    $.ajax({
        method: 'post',
        url: 'board/post',
        data: {title: title, detail: content, pw: password},
        success: function response(result) {
            console.log(result);
            if (result == true) {
                alert("등록 성공");
                _allRead();
            } else {
                alert("등록 실패");
            }
        }
    })
    // 1-1
    // 2-1 입력받지 않은 데이터를 초기화
//   let date = new Date(); // new Date() : 현재 날짜/시간 를 반환해주는 클래스;
//     console.log( date );
//     console.log( date.getFullYear() ); // 연도 만 추출                   2024
//     console.log( date.getMonth() ); // 월 만 추출 ( 1월:0  ~ 12월:11 )    4[5월]
//     console.log( date.getDate() ); //  일 만 추출                         24
//     console.log( date.getHours() ); // 시 만 추출                       11
//     console.log( date.getMinutes() ); // 분 만 추출                     17
//     console.log( date.getSeconds() ); // 초 만 추출                     42
//   // 원하는 날짜 추출 해서 가공
//   let currentYear = date.getFullYear();
//   let currentMonth = date.getMonth()+1 < 10 ? "0"+(date.getMonth()+1) : date.getMonth()+1 ;
//   let currentDay =  date.getDate() < 10 ? "0"+date.getDate() : date.getDate();
//   date = `${ currentYear }-${ currentMonth }-${ currentDay }` // 날짜 구성

//   let view = 0; // 처음 등록시 조회수는 0부터 시작

//   // 3. ,쉼표 구분해서 하나의 문자열로 만들자.
//   let board = `${title},${content},${password},${date},${view}`; console.log( board );
//   // 4. 배열 등록
//   boardList.push( board ); console.log( boardList );
//   alert('등록성공') // 5. 등록 성공
//   _allRead(); // 등록성공시 전체출력 함수 호출
}

// 2. 전체출력 실행조건 : 1. 페이지가 열렸을때(HTML실행->JS실행) 2.데이터가 변화(수정/삭제/등록)가 있을때
_allRead(); // js에서 해당 함수 1번 실행


function _allRead() {

    $.ajax({
        method: 'get',
        url: "/board/get1",
        success: function response(result) {

            console.log(result);
            // 1. 어디에
            let tableBody = document.querySelector('#tableBody');
            // 2. 무엇을
            let html = '';

            result.forEach(tabledto => {
                html += `<tr> 
                        <td> ${tabledto.pno} </td> 
                        <td onclick="_read( ${tabledto.pno} )"> ${tabledto.ptitle} </td> 
                        <td> ${tabledto.pdate} </td>
                        <td> ${tabledto.pview} </td>
                        </tr>`
            });
            tableBody.innerHTML = html;
        }
    });
//   // 1. 어디에
//   let tableBody = document.querySelector('#tableBody');
//   // 2. 무엇을
//   let html = '';
//   for( let i = 0 ; i<boardList.length ; i++ ){ // 배열 순회 : 0번 인덱스부터 마지막인덱스 까지
//     // i번째 게시물 반환
//     let board = boardList[i]; console.log( board );
//     // 게시물의 정보 분류 : 특정 문자 기준으로 분류 .split( 기준문자 ) : 기준문자 기준으로 자른후 배열 반환
//     let boardArray = board.split(',') ; console.log( boardArray );
//     // ,쉼표 기준으로 각 분류된 배열의 정보
//     console.log( boardArray[0] ); console.log( boardArray[3] ); console.log( boardArray[4] );
//     // 각 정보를 HTML 문자열로 구성
//     html += `<tr>
//               <td> ${ i } </td>
//               <td onclick="_read( ${ i } )"> ${ boardArray[0] } </td>
//               <td> ${ boardArray[3] } </td>
//               <td> ${ boardArray[4] } </td>
//             </tr>`
//   }
//   // 3. 출력/대입
//   tableBody.innerHTML = html;
}


// 3. 개별출력 실행조건 : (누구를) 1.제목 클릭했을때
function _read(pno) {
    $.ajax({
        method: 'get',
        url: `/board/get2?pno=${pno}`,
        success: function response(result) {

            console.log(result);
            // 1. 어디에
            let viewPage = document.querySelector('#viewPage');
            // 2. 무엇을
            let html = `<h3> 상세 페이지 </h3>
                        <div> ${result.ptitle} </div>
                        <div> 
                            <span> 조회수 : ${result.pview + 1} </span> 
                            <span> 작성일 : ${result.pdate} </span>
                        </div>
                        <div> ${result.pdetail} </div>
                        <button onclick="_update( ${pno} )">수정</button>
                        <button onclick="_delete( ${pno} )">삭제</button>`;

            viewPage.innerHTML = html;
            _allRead();
        }
    })

    // 선택/클릭 했을때 클릭된 해당 인덱스를 매개변수를 받아서
//   let boardArray = boardList[ index ].split(','); // 해당 인덱스의 게시물 정보를 ,쉼표 기준으로 분류된 배열 반환
//   // 1. 어디에
//   let viewPage = document.querySelector('#viewPage');
//   // 2. 무엇을
//   let html = `<h3> 상세 페이지 </h3>
//               <div> ${ boardArray[0] } </div>
//               <div>
//                 <span> 조회수 : ${ boardArray[4] } </span>
//                 <span> 작성일 : ${ boardArray[3] } </span>
//               </div>
//               <div> ${ boardArray[1] } </div>
//               <button onclick="_update( ${ index } )">수정</button>
//               <button onclick="_delete( ${ index } )">삭제</button>`;
//   // 3. 출력/대입
//   viewPage.innerHTML = html;
}


// 4. 수정함수 실행조건 : (누구를)1. 수정버튼 클릭할떄
function _update(pno) {
    let pw = prompt('비밀번호:');
    let title = prompt('수정할제목');
    let detail = prompt('수정할내용');
    $.ajax({
        method: 'put',
        url: '/board/put',
        data: {pno: pno, title: title, detail: detail, pw: pw},
        success: function response(result) {
            console.log(result);
            if (result == true) {
                alert("수정 성공");
                console.log(pno);
                _read(pno);
            } else {
                alert("수정 실패");
            }
        }
    })
    // 패스워드 검증 함수를 호출후 반환값이 false 이면 수정함수 강제종료
//   if( _pwConfirm(index) == false ) return;

//   // 배열내 특정 데이터 수정
//   let board = boardList[index].split(',');   // 1. 해당 게시물 분류
//     // 새로운 제목과 내용 입력받는다.

//     // 수정할 정보로 구성 : 새로운 제목과 내용만 수정 변수로 구성 하고 나머지는 기존 데이터 사용
//   let uboard = `${ utitle },${ ucontent },${ board[2]},${ board[3]},${ board[4]}`;
//     // 선택된 인덱스의 수정할 정보 대입
//   boardList[index] = uboard;
//     // 화면 새로고침( 재 출력: 데이터 변화가 있기 때문에  )
//   _allRead();
//   _read( index );
} // for end

// 5. 삭제함수 실행조건 : (누구를)1. 삭제버튼 클릭할때
function _delete(pno) {
    let pw = prompt('비밀번호:');
    $.ajax({
        method: 'delete',
        url: '/board/delete',
        data: {pno: pno, pw: pw},
        success: function response(result) {
            console.log(result);
            if (result == true) {
                alert("삭제 성공");
                _allRead();
                document.querySelector('#viewPage').innerHTML = ``;
            } else {
                alert("삭제 실패");
            }
        }
    })
//   // 패스워드 검증 함수를 호출후 반환값이 false 이면 삭제함수 강제종료
//   if( _pwConfirm(index) == false ) return;

//   // 배열내 특정 인덱스 삭제
//   boardList.splice( index , 1 );
//   // 화면 새로고침( 재 출력: 데이터 변화가 있기 때문에  )
//   _allRead();
//   document.querySelector('#viewPage').innerHTML = ``;
}

// 6. 패스워드 체크 함수
// function _pwConfirm( index ){
//   // - 패스워드 검증
//   // 1. 검증받을 패스워드 입력받는다.
//   let confirmPw = prompt('비밀번호:');
//   // 2. 해당 인덱스의 비밀번호 와 입력받은 비밀번호가 다르면 함수를 중간에 종료한다.
//   if( confirmPw != boardList[index].split(',')[2] ){
//     alert('패스워드가 다릅니다. ');
//     return false ; // 패스워드 일치 실패 뜻 , 함수 종료 , 이하 아래 코드는 실행이 안됨.
//   }
//   return true; // 패스워드 일치 성공 뜻
// }

// + 조회수 증가함수 생각해보기