package example.day13;

public class Member implements Comparable<Member> {
    private final String name;
    private final int age;

    public Member(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Member 객체의 자연 순서를 정의하는 compareTo 메서드 구현
    @Override
    public int compareTo(final Member other) {
        // 1. name 기준으로 정렬하는 방법
        // return this.name.compareTo(other.name);
        // 2. age 기준으로 정렬하는 방법, int는 기본타입이므로 직접 정렬기준 비교해야 함.
        // 오름차순: 매개변수보다 더 작으면 -1, 같으면 0, 매개변수보다 크면 1
        // 내림차순: 매개변수보다 더 작으면 1, 같으면 0, 매개변수보다 크면 -1
        if (this.age < other.age) {
            return -1;
        } else if (this.age > other.age) {
            return 1;
        } else {
            return 0;
        }

    }
}
