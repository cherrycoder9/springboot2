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
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                boardDto = BoardDto.builder()
                        .bcno(rs.getLong("bcno"))
                        .bcname(rs.getString("bcname"))
                        .build();

                list.add(boardDto);
            } return list;

        }catch (Exception e) {System.out.println(e);} return null;
    }

    public ArrayList<BoardDto> all(){
        System.out.println("BoardDao.all");
        ArrayList<BoardDto> list = new ArrayList<>();
        System.out.println("null-1");
        try{
            System.out.println("null-2");
            BoardDto boardDto;
            String sql = "select bno , btitle , bcontent , bview, bdate , no from board;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("null-3");
            while(rs.next()){
                boardDto = BoardDto.builder()
                        .bno(rs.getLong("bno"))
                        .btitle(rs.getString("btitle"))
                        .bcontent(rs.getString("bcontent"))
                        .bview(rs.getLong("bview"))
                        .bdate(rs.getString("bdate"))
                        .no(rs.getLong("no"))
                        .build();

                System.out.println("null-4");
                list.add(boardDto);
                System.out.println(list);
            } return list;
        } catch (Exception e) {System.out.println(e);}
        System.out.println("null");
        return null;
    }

}//class end
