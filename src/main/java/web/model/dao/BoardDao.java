package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.BoardDto;

import java.util.ArrayList;

@Component //
public class BoardDao extends Dao{

    public ArrayList<BoardDto> category(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try{
            BoardDto boardDto;
            String sql = "select * from bcategory";
            conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                boardDto = BoardDto.builder()
                        .bcno(rs.getLong("bcno"))
                        .bcname(rs.getString("bcname"))
                        .build();

                list.add(boardDto);
            }

        }catch (Exception e) {System.out.println(e);} return list;
    }
}//class end
