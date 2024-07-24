package example.day09.board;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


@Component
public class BoardDao {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    private BoardDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Board", "root", "1234");
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    //  1. get
    public ArrayList<BoardDto> boardGet1() {
        final ArrayList<BoardDto> list = new ArrayList<>();
        try {
            final String sql = "select *from wholepage";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                final BoardDto boardDto = new BoardDto();
                boardDto.setPno(rs.getInt("pno"));
                boardDto.setPtitle(rs.getString("ptitle"));
                boardDto.setPdate(rs.getString("pdate"));
                boardDto.setPview(rs.getInt("pview"));

                list.add(boardDto);
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public BoardDto boardGet2(final int pno) {
        try {
            final String sql = "select *from wholepage where pno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            rs = ps.executeQuery();
            if (rs.next()) {
                final BoardDto boardDto = new BoardDto();
                boardDto.setPno(rs.getInt("pno"));
                boardDto.setPtitle(rs.getString("ptitle"));
                boardDto.setPdate(rs.getString("pdate"));
                boardDto.setPview(rs.getInt("pview"));
                boardDto.setPdetail(rs.getString("pdetail"));

                return boardDto;
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //  조회수 증가 함수
    public boolean viewUpdate(final int pno) {
        try {
            final String sql = "update wholepage set pview = pview + 1 where pno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            final int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //  2. post
    public boolean boardPost(final String title, final String detail, final String pw) {
        try {
            final String sql = "insert wholepage(ptitle, pdetail, ppwd) values(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, detail);
            ps.setString(3, pw);
            final int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //  3. put
    public boolean boardPut(final String title, final String detail, final String pw, final int pno) {
        try {
            final String sql = "update wholepage set ptitle = ? , pdetail = ? where ppwd = ? and pno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, detail);
            ps.setString(3, pw);
            ps.setInt(4, pno);
            final int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //  4. delete
    public boolean boardDelete(final String pw, final int pno) {
        try {
            final String sql = "delete from wholepage where pno = ? and ppwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            ps.setString(2, pw);
            final int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }
}