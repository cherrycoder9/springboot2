package example.day12;

import java.util.Objects;

public class User {
    private String name;
    private int age;

    public User() {

    }

    public User(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
}

/*
* - 공통 코드
    while(true) {
        System.out.print("1.등록 2.전체출력 3.수정 4.삭제");
    }

- 공통 조건
    - 1.등록: 이름과 나이를 입력받아 컬렉션 저장
    - 2.전체출력: 컬렉션내 저장된 모든 데이터를 출력

- [1] LinkedList 구현 -> Step3, User클래스{필드: 이름, 나이}
    - 3.수정: 전체출력된 인덱스를 보고 인덱스를 입력받아 동일한 인덱스가 존재하면 새로운 나이 입력받아 나이 수정처리
    - 4.삭제: 전체출력된 인덱스를 보고 인덱스를 입력받아 동일한 인덱스가 존재하면 요소 삭제

- [2] HashSet 구현 -> Step4, User클래스{필드: 이름, 나이}
    * 등록시 동일한 이름을 저장하지 않는다.
    - 3.수정: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 새로운 나이를 입력받아 나이 수정처리
    - 4.삭제: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 요소 삭제

- [3] HashMap 구현 -> Step5, 이건 User클래스 쓰지 말 것, 이유: Map 컬렉션 제네릭타입 2개(key,value), key=이름, value=나이
    * 등록시 동일한 이름을 저장하지 않는다.
    - 3.수정: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 새로운 나이를 입력받아 나이 수정처리
    - 4.삭제: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 요소 삭제
* */
