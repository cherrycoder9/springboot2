package web.contoller;

import bootcamp.springboot2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board") //공통 URL : BOARD 생성

public class BoardController {

    @Autowired BoardService boardService; //

    @GetMapping("/category")
    public String category(){
        //로그인 상태
        return BoardService.category();
    }

}
