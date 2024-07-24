package example.day07.todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoDao tDao = TodoDao.getInstance();

    @GetMapping
    public List<TodoDto> getTodos() {
        return tDao.getTodos();
    }

    @PostMapping("/create")
    public boolean postTodos(@RequestParam("todo") final String todo) {
        System.out.println("todo = " + todo);
        return tDao.postTodos(todo);
    }

    @PutMapping("/update")
    public boolean putTodos(@RequestParam("id") final int id) {
        System.out.println("id = " + id);
        return tDao.putTodos(id);
    }

    @DeleteMapping("/delete")
    public boolean deleteTodos(@RequestParam("id") final int id) {
        System.out.println("id = " + id);
        return tDao.deleteTodos(id);
    }
}
