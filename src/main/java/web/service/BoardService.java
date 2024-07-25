// src\main\java\web\service\BoardService.java

package web.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;
    @Autowired
    private HttpServletRequest request;

    public ArrayList<BoardDto> category() {

        return boardDao.category();
    }

    public ArrayList<BoardDto> all() {
        System.out.println("BoardService.all");
        return boardDao.all();
    }

    // 글쓰기 처리 service (처리후 dao로 넘김)
    @PostMapping("/write")
    public boolean bWrite(final String btitle, final String bcontent, final Long bcno) {
        // 세션에서 로그인된 사용자 정보 가져오기
        final HttpSession session = request.getSession();
        final MemberDto loginDto = (MemberDto) session.getAttribute("loginDto");

        if (loginDto == null) {
            // 로그인되지 않은 상태라면 false 반환
            return false;
        }

        // 로그인된 사용자의 회원 번호 가져오기
        final Long no = (long) loginDto.getNo();

        // DAO로 데이터 전달
        return boardDao.bWrite(btitle, bcontent, bcno, no);
    }

    // 글 상세페이지 출력 service (처리후 dao로 넘김)
    @GetMapping("/detail")
    public BoardDto bDetail(final Long bno) {
        return boardDao.bDetail(bno);
    }

    // 삭제 처리 요청 service
    public boolean deleteBoard(final Long bno) {
        return boardDao.deleteBoard(bno);
    }

    // 글 수정 service
    public boolean updateBoard(BoardDto boardDto) {
        return boardDao.updateBoard(boardDto);
    }
}
