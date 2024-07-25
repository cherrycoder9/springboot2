package web.model.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public ArrayList<BoardDto> all() {
        System.out.println("BoardDao.all");
        final ArrayList<BoardDto> list = new ArrayList<>();
        System.out.println("null-1");
        try {
            System.out.println("null-2");
            BoardDto boardDto;
            final String sql = "select bno , btitle , bcontent , bview, bdate , no from board";
            final PreparedStatement ps = conn.prepareStatement(sql);
            final ResultSet rs = ps.executeQuery();
            System.out.println("null-3");
            while (rs.next()) {
                System.out.println("bno출력: ");
                boardDto = BoardDto.builder()
                        .bno(rs.getLong("bno"))
                        .btitle(rs.getString("btitle"))
                        .bcontent(rs.getString("bcontent"))
                        .bview(rs.getLong("bview"))
                        .bdate(rs.getString("bdate"))
                        .no(rs.getLong("no"))
                        .build();

                System.out.println("null-4");
                list.add(boardDto);
                System.out.println(list);
            }
            return list;
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        System.out.println("null");
        return null;
    }

    // 글쓰기 처리 dao
    @PostMapping("/write")
    public boolean bWrite(final String btitle, final String bcontent, final Long bcno, final Long no) {
        System.out.println("BoardDao.bWrite");
        try {
            final String sql = "insert into board(btitle, bcontent, bcno, no) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, btitle);
            ps.setString(2, bcontent);
            ps.setLong(3, bcno);
            ps.setLong(4, no);
            ps.executeUpdate();
            return true;
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return false;
    }

    // 글 상세페이지 출력 dao
    @GetMapping("/detail")
    public BoardDto bDetail(final Long bno) {
        System.out.println("BoardDao.bDetail");
        try {
            final BoardDto boardDto;
            final String sql = "select bno , btitle , bcontent , bview, bdate , no from board where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, bno);
            rs = ps.executeQuery();
            if (rs.next()) {
                boardDto = BoardDto.builder()
                        .bno(rs.getLong("bno"))
                        .btitle(rs.getString("btitle"))
                        .bcontent(rs.getString("bcontent"))
                        .bview(rs.getLong("bview"))
                        .bdate(rs.getString("bdate"))
                        .no(rs.getLong("no"))
                        .build();
                return boardDto;
            }
        } catch (final Exception e) {
            log.error("e: ", e);
        }
        return null;
    }

}//class end
