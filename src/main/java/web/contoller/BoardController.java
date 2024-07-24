package web.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.BoardDto;
import web.service.BoardService;

import java.util.ArrayList;

@RestController
@RequestMapping("/board") //공통 URL : BOARD 생성

public class BoardController {

    @Autowired BoardService boardService; //

    @GetMapping("/category")
    public ArrayList<BoardDto> category ( ){
        return boardService.category();
    }


}
