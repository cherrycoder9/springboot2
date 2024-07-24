let todoList = [];

function add() {
    console.log("add()");
    let todoInput = document.querySelector('#todoList');
    console.log(todoInput);
    let todo = todoInput.value;
    console.log(todo);

    $.ajax({
        method: "post", // HTTP 메소드 선택
        url: "/todos/create", // HTTP 통신할 경로 작성
        data: {
            todo: todo
        },
        success: function (resp) {
            if (resp) {
                alert('등록 완료');
                print();
            } else {
                alert('등록 안됨');
            }
        }
    });
    todoInput.value = "";
}

function print() {
    console.log("print()");
    $.ajax({
        method: "get", // HTTP 메소드 선택
        url: "/todos",  // 백엔드 서버 주소를 정확히 지정
        success: function (data) {
            console.log(data);
            todoList = data;  // 받아온 데이터를 todoList에 저장
            renderTodoList();  // 데이터를 화면에 표시
        }
    });
}

function renderTodoList() {
    let html = ``;
    for (let i = 0; i < todoList.length; i++) {
        let currentTodo = todoList[i];
        html += `
            <div class="${currentTodo.completed ? 'doneTodo' : 'willTodo'}">
                <div>${currentTodo.todo}</div>
                <div>
                    <button onclick="update(${currentTodo.id})">변경</button>
                    <button onclick="remove(${currentTodo.id})">삭제</button>
                </div>   
            </div>
        `;
    }
    document.getElementById('tableBox').innerHTML = html;
}

// 페이지 로드 시 데이터 가져오기
print();

function remove(index) {
    console.log("remove()");
    $.ajax({
        method: "delete", // HTTP 메소드 선택
        url: "/todos/delete", // HTTP 통신할 경로 작성
        data: {
            id: index
        },
        success: function (resp) {
            if (resp) {
                alert("삭제 완료");
                print();
            } else {
                alert("삭제 실패");
            }
        }
    });
}

function update(index) {
    console.log("update()");
    console.log(typeof index);
    $.ajax({
        method: "put", // HTTP 메소드 선택
        url: "/todos/update", // HTTP 통신할 경로 작성
        data: {
            id: index
        },
        success: function (resp) {
            if (resp) {
                console.log("성공적으로 변경됨");
                print();
            } else {
                console.log("변경 안됨");
            }
        }
    });
}