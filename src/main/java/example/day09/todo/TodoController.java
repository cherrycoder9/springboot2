package example.day09.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public List<TodoDto> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/create")
    public boolean postTodos(@RequestParam("todo") final String todo) {
        System.out.println("todo = " + todo);
        return todoService.postTodos(todo);
    }

    @PutMapping("/update")
    public boolean putTodos(@RequestParam("id") final int id) {
        System.out.println("id = " + id);
        return todoService.putTodos(id);
    }

    @DeleteMapping("/delete")
    public boolean deleteTodos(@RequestParam("id") final int id) {
        System.out.println("id = " + id);
        return todoService.deleteTodos(id);
    }
}
