package web.service;

import bootcamp.springboot2.model.dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired BoardDao boardDao;

    public String category(){

    }
}
