// src\main\java\web\model\dao\BoardDao.java

package web.model.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import web.model.dto.BoardDto;

import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Slf4j
@Component //
public class BoardDao extends Dao {

    public ArrayList<BoardDto> category() {
        final ArrayList<BoardDto> list = new ArrayList<>();
        try {
            BoardDto boardDto;
            final String sql = "select * from bcategory";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                boardDto = BoardDto.builder()
                        .bcno(rs.getLong("bcno"))
                        .bcname(rs.getString("bcname"))
                        .build();
                list.add(boardDto);
            }
            return list;

        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return null;
    }

    // 글 전체 출력 dao
    public ArrayList<BoardDto> all() {
        System.out.println("BoardDao.all");
        final ArrayList<BoardDto> list = new ArrayList<>();
        try {
            final String sql = "SELECT b.bno, b.btitle, b.bcontent, b.bview, b.bdate, b.no, m.id " +
                    "FROM board b " +
                    "JOIN member m ON b.no = m.no";
            final PreparedStatement ps = conn.prepareStatement(sql);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final BoardDto boardDto = BoardDto.builder()
                        .bno(rs.getLong("bno"))
                        .btitle(rs.getString("btitle"))
                        .bcontent(rs.getString("bcontent"))
                        .bview(rs.getLong("bview"))
                        .bdate(rs.getString("bdate"))
                        .no(rs.getLong("no"))
                        .id(rs.getString("id")) // 작성자 ID 추가
                        .build();
                list.add(boardDto);
            }
            return list;
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return null;
    }


    // 글쓰기 처리 dao
    // 글쓰기 처리 dao
    public boolean bWrite(final String btitle, final String bcontent, final Long bcno, final Long no, final String filePath) {
        System.out.println("BoardDao.bWrite");
        try {
            final String sql = "INSERT INTO board(btitle, bcontent, bcno, no, bfile) VALUES(?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, btitle);
            ps.setString(2, bcontent);
            ps.setLong(3, bcno);
            ps.setLong(4, no);
            // 파일 경로에서 파일명만 추출
            final String fileName = filePath != null ? Paths.get(filePath).getFileName().toString() : null;
            ps.setString(5, fileName);
            ps.executeUpdate();
            return true;
        } catch (final Exception e) {
            log.error("Error in bWrite: ", e);
        }
        return false;
    }


    // 글 상세페이지 출력 dao
    public BoardDto bDetail(final Long bno) {
        System.out.println("BoardDao.bDetail");
        try {
            conn.setAutoCommit(false);
            final String updateViewCountSql = "UPDATE board SET bview = bview + 1 WHERE bno = ?";
            ps = conn.prepareStatement(updateViewCountSql);
            ps.setLong(1, bno);
            ps.executeUpdate();

            final String sql = "SELECT b.bno, b.btitle, b.bcontent, b.bview, b.bdate, b.no, c.bcname, m.id, b.bfile " +
                    "FROM board b " +
                    "JOIN bcategory c ON b.bcno = c.bcno " +
                    "JOIN member m ON b.no = m.no " +
                    "WHERE b.bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, bno);
            rs = ps.executeQuery();

            BoardDto boardDto = null;
            if (rs.next()) {
                boardDto = BoardDto.builder()
                        .bno(rs.getLong("bno"))
                        .btitle(rs.getString("btitle"))
                        .bcontent(rs.getString("bcontent"))
                        .bview(rs.getLong("bview"))
                        .bdate(rs.getString("bdate"))
                        .no(rs.getLong("no"))
                        .bcname(rs.getString("bcname"))
                        .id(rs.getString("id"))
                        .bfile(rs.getString("bfile"))
                        .build();
            }
            conn.commit();
            return boardDto;
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return null;
    }


    // 삭제 처리 요청 dao
    public boolean deleteBoard(final Long bno) {
        final String sql = "DELETE FROM board WHERE bno = ?";
        try (final PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, bno);
            final int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (final SQLException e) {
            log.error("e: ", e);
        }
        return false;
    }

    // 글 수정 dao
    public boolean updateBoard(final BoardDto boardDto) {
        final String sql = "UPDATE board SET btitle = ?, bcontent = ?, bcno = ? WHERE bno = ?";
        try (final PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, boardDto.getBtitle());
            ps.setString(2, boardDto.getBcontent());
            ps.setLong(3, boardDto.getBcno());
            ps.setLong(4, boardDto.getBno());
            return ps.executeUpdate() > 0;
        } catch (final SQLException e) {
            log.error("SQL Exception: ", e);
        }
        return false;
    }
}//class end
