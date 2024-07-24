package web.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.BoardService;

@RestController
@RequestMapping("/board") //공통 URL : BOARD 생성

public class BoardController {

    @Autowired BoardService boardService; //



}
