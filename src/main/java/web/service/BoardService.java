package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.BoardDao;

@Service
public class BoardService {

    @Autowired BoardDao boardDao;

//    public String category(){
//
//    }
}
