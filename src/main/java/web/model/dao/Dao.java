package web.model.dao;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Dao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    // 슈퍼클래스를 써서 DB 연동하는 부모 클래스로 사용
    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb", "root", "1234");
        } catch (final SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
