package example.day02.consolemvc.model.dao;

import example.day02.consolemvc.model.dto.PhoneDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PhoneDao {
    // [1] 싱글톤 패턴
    private static final PhoneDao phoneDao = new PhoneDao();
    // 데이터베이스 연결 정보
    private static final String DB_URL = "jdbc:mysql://localhost:3306/springexample";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    // [2]
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private PhoneDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static PhoneDao getInstance() {
        return phoneDao;
    }

    // 1.
    public boolean postPhone(PhoneDto phoneDto) {
        try {
            String sql = "insert into phonebook(name, phone) values(?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, phoneDto.getName());
            ps.setString(2, phoneDto.getPhone());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 2.
    public ArrayList<PhoneDto> getPhone() {
        ArrayList<PhoneDto> list = new ArrayList<>();
        try {
            String sql = "select * from phonebook";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                PhoneDto phoneDto = new PhoneDto(id, name, phone);
                list.add(phoneDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


}

/*
    서로 다른 클래스들 간의 메소드를 호출하는 방법

    1. 인스턴스 생성해서 변수
        클래스명 변수명 = new 생성자명();
        변수명.메소드명();

    2. 인스턴스 생성 후 메소드 호출
        new 생성자명().메소드명();

    3. [싱글톤] 미리 인스턴스 만들고 미리 만든 인스턴스 호출 후 메소드 호출
        클래스명.getInstance().메소드명();

    4. 메소드가 static 으로 선언되었을 때
        클래스명.메소드명();
 */