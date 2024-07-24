package example.day09.todo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {
    private static final Logger log = LogManager.getLogger(TodoDao.class);
    private Connection conn;

    // private 생성자
    private TodoDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "1234");
        } catch (final Exception e) {
            log.error("데이터베이스 연결 초기화 오류: ", e);
        }
    }

    // 투두리스트 DB 가져오기
    public List<TodoDto> getTodos() {
        final List<TodoDto> todos = new ArrayList<>();
        try {
            final String sql = "select * from todo";
            final PreparedStatement ps = conn.prepareStatement(sql);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final int id = rs.getInt("id");
                final String todo = rs.getString("todo");
                final int completed = rs.getInt("completed");
                final TodoDto todoDto = new TodoDto(id, todo, completed);
                todos.add(todoDto);
            }
            return todos;
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return null;
    }

    // 투두리스트 추가하기
    public boolean postTodos(final String todo) {
        final String sql = "insert into todo(todo) values(?)";
        try {
            final PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, todo);
            ps.executeUpdate();
            return true;
        } catch (final SQLException e) {
            log.error("e: ", e);
        }
        return false;
    }

    // 투두리스트 completed 상태 변경하기
    public boolean putTodos(final int id) {
        final String sql1 = "select completed from todo where id = ?";
        final String sql2 = "update todo set completed = ? where id = ?";

        try (final PreparedStatement ps1 = conn.prepareStatement(sql1)) {
            ps1.setInt(1, id);
            try (final ResultSet rs1 = ps1.executeQuery()) {
                if (rs1.next()) {
                    final int completed = rs1.getInt("completed");
                    try (final PreparedStatement ps2 = conn.prepareStatement(sql2)) {
                        ps2.setInt(1, completed == 0 ? 1 : 0);
                        ps2.setInt(2, id);
                        ps2.executeUpdate();
                        return true;
                    }
                }
            }
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return false;
    }

    // 투두리스트 삭제하기
    public boolean deleteTodos(final int id) {
        final String sql = "delete from todo where id = ?";
        try {
            final PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (final SQLException e) {
            log.error("e: ", e);
        }
        return false;
    }
}
