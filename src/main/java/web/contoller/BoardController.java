package web.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.BoardDto;
import web.service.BoardService;

import java.util.ArrayList;

@RestController
@RequestMapping("/board") //공통 URL : BOARD 생성

public class BoardController {

    @Autowired
    BoardService boardService; //

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
    // btitle, bcontent, bcno, no (글제목, 글내용, 카테고리, 회원번호)
    // 회원번호는 여기서 안하고 서비스단에서 세션으로 확인한 다음에 처리
    // 반환값은 글쓰기 성공 실패, 불리언 값 반환
    @PostMapping("/write")
    public boolean bWrite() {
        return true;
    }

    // 글 상세페이지 출력 컨트롤러
    // 매개변수 입력값 bno
    // 리턴값 json(bno, btitle, bcontent, bdate, bview, bcno)
    @GetMapping("/detail")
    public BoardDto bDetail(final Long bno) {
        return BoardService.bDetail(bno);
    }
}
