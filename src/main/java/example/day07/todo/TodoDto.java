package example.day07.todo;

public class TodoDto {
    private int id;
    private String todo;
    private int completed;

    public TodoDto() {
    }

    public TodoDto(final int id, final String todo, final int completed) {
        this.id = id;
        this.todo = todo;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(final int completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", todo='" + todo + '\'' +
                ", completed=" + completed +
                '}';
    }
}
