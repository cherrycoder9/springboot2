// src\main\java\web\contoller\BoardController.java

package web.contoller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;
import web.service.BoardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/board") //공통 URL : BOARD 생성
public class BoardController {
    @Autowired
    BoardService boardService; //

    @Autowired
    HttpServletRequest request;


    @GetMapping("/category")
    public ArrayList<BoardDto> category() {
        return boardService.category();
    }

    @GetMapping("/all")
    public ArrayList<BoardDto> all() {
        System.out.println("BoardController.all");
        return boardService.all();
    }

    // 글쓰기 처리 컨트롤러 (서비스단으로 넘김)
    // ajax 입력값 btitle, bcontent, bcno, no (글제목, 글내용, 첨부파일, 카테고리, 회원번호)
    // 회원번호는 여기서 안하고 서비스단에서 세션으로 확인한 다음에 처리
    // 반환값은 글쓰기 성공 실패, 불리언 값 반환
    @PostMapping("/write")
    public boolean bWrite(@RequestParam("btitle") final String btitle,
                          @RequestParam("bcontent") final String bcontent,
                          @RequestParam("bcno") final Long bcno,
                          @RequestParam("bfile") final MultipartFile bfile) {
        return boardService.bWrite(btitle, bcontent, bcno, bfile);
    }


    // 글 상세페이지 출력 컨트롤러
    // 매개변수 입력값 bno
    // 리턴값 json(bno, btitle, bcontent, bdate, bview, bcno)
    // 첨부파일도 보이도록 수정해야 함
    @GetMapping("/detail")
    public Map<String, Object> bDetail(@RequestParam final Long bno) {
        final HttpSession session = request.getSession();
        String loggedInUserId = null;

        final MemberDto loginDto = (MemberDto) session.getAttribute("loginDto");
        if (loginDto != null) {
            loggedInUserId = loginDto.getId();
        }

        final BoardDto boardDto = boardService.bDetail(bno);

        final Map<String, Object> response = new HashMap<>();
        response.put("board", boardDto);
        response.put("loggedInUserId", loggedInUserId);
        return response;
    }


    // 글 삭제 요청 api (서비스로 넘김)
    @DeleteMapping("/delete")
    public boolean deleteBoard(@RequestBody final Map<String, Long> requestData) {
        final Long bno = requestData.get("bno");
        return boardService.deleteBoard(bno);
    }

    // 글 수정 요청 api (서비스로 넘김)
    @PutMapping("/update")
    public boolean updateBoard(@RequestBody final BoardDto boardDto) {
        return boardService.updateBoard(boardDto);
    }
}
