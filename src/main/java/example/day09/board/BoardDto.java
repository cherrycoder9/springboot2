package example.day09.board;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BoardDto {
    private int pno;
    private String ptitle;
    private String pdate;
    private int pview;
    private String pdetail;
    private String ppwd;

}