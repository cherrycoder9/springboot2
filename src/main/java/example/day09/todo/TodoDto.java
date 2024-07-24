package example.day09.todo;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TodoDto {
    private int id;
    private String todo;
    private int completed;
}
