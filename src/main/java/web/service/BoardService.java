package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

import java.util.ArrayList;

@Service
public class BoardService {

    @Autowired BoardDao boardDao;

    public ArrayList<BoardDto> category( ){

        return boardDao.category();
    }

    public ArrayList<BoardDto> all(){
        System.out.println("BoardService.all");
        return boardDao.all();
    }
}
