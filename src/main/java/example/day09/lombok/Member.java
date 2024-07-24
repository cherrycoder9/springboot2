package example.day09.lombok;

import lombok.*;

@Builder // 해당 클래스의 빌더 패턴 주입/생성
@AllArgsConstructor // 해당 클래스의 풀 생성자 자동으로 주입/생성
@NoArgsConstructor // 해당 클래스 빈 기본 생성자 자도응로 주입/생성
@ToString // 해당 클래스의 toString 메소드를 자동 재정의
@Getter // 해당 클래스의 getter 메소드를 자동으로 주입/생성
@Setter // 해당 클래스의 setter 메소드를 자동으로 주입/생성
public class Member {
    // 필드
    private int id;
    private String name;

}
