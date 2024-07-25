// src\main\java\web\service\BoardService.java

package web.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;
    @Autowired
    HttpServletRequest request;
    @Autowired
    FileService fileService;


    public ArrayList<BoardDto> category() {

        return boardDao.category();
    }

    public ArrayList<BoardDto> all() {
        System.out.println("BoardService.all");
        return boardDao.all();
    }

    // 글쓰기 처리 service (처리후 dao로 넘김)
    public boolean bWrite(final String btitle, final String bcontent, final Long bcno, final MultipartFile bfile) {
        // 세션에서 로그인된 사용자 정보 가져오기
        final HttpSession session = request.getSession();
        final MemberDto loginDto = (MemberDto) session.getAttribute("loginDto");

        if (loginDto == null) {
            return false;
        }

        final Long no = (long) loginDto.getNo();
        String filePath = null;

        // 파일 업로드 처리
        if (bfile != null && !bfile.isEmpty()) {
            try {
                filePath = fileService.fileUpload(bfile);
            } catch (final IOException e) {
                log.error("e: ", e);
            }
        }

        return boardDao.bWrite(btitle, bcontent, bcno, no, filePath);
    }

    // 글 상세페이지 출력 service (처리후 dao로 넘김)
    public BoardDto bDetail(final Long bno) {
        return boardDao.bDetail(bno);
    }


    // 삭제 처리 요청 service
    public boolean deleteBoard(final Long bno) {
        return boardDao.deleteBoard(bno);
    }

    // 글 수정 service
    public boolean updateBoard(final BoardDto boardDto) {
        return boardDao.updateBoard(boardDto);
    }
}
