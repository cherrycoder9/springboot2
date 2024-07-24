package example.day09.lombok;

public class Step1 {
    public static void main(final String[] args) {
        // Member 객체 생성
        final Member m1 = new Member();
        m1.setId(123);
        m1.setName("유재석");

        System.out.println(m1.getId());
        System.out.println(m1.getName());

        System.out.println(m1);

        // Member 객체 생성
        final Member m2 = new Member(11, "강호동");
        System.out.println(m2);


        // 생성자는 규칙: 메소드와 동일하게 매개변수의 순서, 타입, 개수 일치해야 함
        final Member m3 = new Member(12, "2zx");
        System.out.println(m3);

        // 빌더 패턴: 객체 생성 과정에서 표현 방법을 분리하여 다른 표현으로 객체 생성
        // 필요한 데이터만 설정할 수 있다. 유연성 확보, 가독성 높일 수 있다.
        // 빌더 패턴 - 실수를 방지하기 위한?
        final Member m4 = Member.builder()
                .name("신동엽")
                .id(13)
                .build();
        System.out.println(m4);
    }
}
