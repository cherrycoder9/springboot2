package example.day09.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    //  1. get
    public ArrayList<BoardDto> boardGet1() {
        final ArrayList<BoardDto> list = boardDao.boardGet1();
        return list;
    }

    public BoardDto boardGet2(final int pno) {
        BoardDto boardDto = new BoardDto();
        boardDto = boardDao.boardGet2(pno);
        boardDao.viewUpdate(pno);
        return boardDto;
    }

    //  2. post
    public boolean boardPost(final String title, final String detail, final String pw) {
        return boardDao.boardPost(title, detail, pw);
    }

    //  3. put
    public boolean boardPut(final String title, final String detail, final String pw, final int pno) {
        return boardDao.boardPut(title, detail, pw, pno);
    }

    //  4. delete
    public boolean boardDelete(final String pw, final int pno) {
        return boardDao.boardDelete(pw, pno);
    }
}
