package web.model.dto;

import lombok.*;
@Builder @Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class BoardDto {
    private long bno ;          // 번호
    private String btitle;      // 제목
    private String bcontent;        // 내용
    private String bfile;       // 첨부파일
    private long bview ;        // 조회수
    private String bdate;       // 작성일
    // 카테고리
    private long bcno ;         // 카테고리 번호
    private String bcname ;         // 카테고리 이름
    // 회원
    private long no ;          // 작성자 번호
    private String id;          // 작성자 아이디

}
