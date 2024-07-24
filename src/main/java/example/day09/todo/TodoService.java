package example.day09.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public List<TodoDto> getTodos() {
        return todoDao.getTodos();
    }

    public boolean postTodos(@RequestParam("todo") final String todo) {
        System.out.println("todo = " + todo);
        return todoDao.postTodos(todo);
    }

    public boolean putTodos(@RequestParam("id") final int id) {
        System.out.println("id = " + id);
        return todoDao.putTodos(id);
    }

    public boolean deleteTodos(@RequestParam("id") final int id) {
        System.out.println("id = " + id);
        return todoDao.deleteTodos(id);
    }
}
