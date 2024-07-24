package web.model.dto;

import lombok.*;

@Builder // 해당 클래스의 빌더 패턴 주입/생성
@AllArgsConstructor // 해당 클래스의 풀 생성자 자동으로 주입/생성
@NoArgsConstructor // 해당 클래스 빈 기본 생성자 자도응로 주입/생성
@ToString // 해당 클래스의 toString 메소드를 자동 재정의
@Getter // 해당 클래스의 getter 메소드를 자동으로 주입/생성
@Setter // 해당 클래스의 setter 메소드를 자동으로 주입/생성
public class MemberDto {
    private int no;
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;

    /*
    *     no bigint auto_increment ,            -- 회원번호
          id varchar(30) not null unique ,            -- 회원 아이디
          pw varchar(30) not null ,            -- 회원 비밀번호
          name varchar(20) not null ,            -- 회원 이름
          email varchar(50) ,               -- 회원 이메일
          phone varchar(13) not null unique,         -- 회원 핸드폰 번호
          constraint member_no_pk primary key(no )       -- 회원 번호 pk
    * */
}
