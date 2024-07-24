package example.day12;

import java.util.HashSet;
import java.util.Scanner;

public class Step4 {
    public static void main(final String[] args) {
    /*
    * - 공통 조건
    - 1.등록: 이름과 나이를 입력받아 컬렉션 저장
    - 2.전체출력: 컬렉션내 저장된 모든 데이터를 출력
    - HashSet 구현 -> Step4, User클래스{필드: 이름, 나이}
    * 등록시 동일한 이름을 저장하지 않는다.
    - 3.수정: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 새로운 나이를 입력받아 나이 수정처리
    - 4.삭제: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 요소 삭제
    * */
        final HashSet<User> users = new HashSet<>();
        final Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1.등록 2.전체출력 3.수정 4.삭제 5. 종료");
            System.out.print(">> ");
            final String ch = scan.next();
            switch (ch) {
                case "1" -> {
                    // 1.등록: 이름과 나이를 입력받아 컬렉션 저장
                    System.out.println("1번 입력되었음");

                    // 이름 입력
                    System.out.println("이름을 입력하세요");
                    System.out.print(">> ");
                    final String name = scan.next();

                    // 중복되는 이름이 있는지 검사한다.
                    boolean exists = false;
                    for (final User user : users) {
                        if (user.getName().equals(name)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("중복되는 이름이 있음");
                        continue;
                    }

                    // 나이 입력
                    System.out.println("나이를 입력하세요");
                    System.out.print(">> ");
                    final int age = scan.nextInt();

                    final User user = new User(name, age);
                    users.add(user);
                    System.out.println("등록완료: " + user);
                }
                case "2" -> {
                    // 2.전체출력: 컬렉션내 저장된 모든 데이터를 출력
                    System.out.println("2번 입력되었음");

                    // 만약 등록된 user가 없는 경우 없다고 알리고 종료한다
                    if (users.isEmpty()) {
                        System.out.println("등록된 회원이 없음");
                        continue;
                    }

                    // HashSet users 출력, 인덱스도 같이 출력한다.
                    int index = 0;
                    for (final User user : users) {
                        System.out.println(index + "번: " + user);
                        index++;
                    }
                }
                case "3" -> {
                    // 3.수정: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 새로운 나이를 입력받아 나이 수정처리
                    System.out.println("3번 입력되었음");

                    // 이름 입력
                    System.out.println("이름을 입력하세요");
                    System.out.print(">> ");
                    final String name = scan.next();

                    // 이름이 없으면 출력
                    User userToUpdate = null;
                    for (final User user : users) {
                        if (user.getName().equals(name)) {
                            userToUpdate = user;
                            break;
                        }
                    }

                    if (userToUpdate == null) {
                        System.out.println("이름이 없음");
                        continue;
                    }

                    // 나이 입력
                    System.out.println("나이를 입력하세요");
                    System.out.print(">> ");
                    final int newAge = scan.nextInt();


                    // 해당하는 이름을 가진 사람에게 새로운 나이를 저장함
                    userToUpdate.setAge(newAge);
                    System.out.println("수정완료: " + userToUpdate);
                }
                case "4" -> {
                    // 4.삭제: 전체출력된 이름을 보고 이름을 입력받아 동일한 이름이 존재하면 요소 삭제
                    System.out.println("4번 입력되었음");

                    // 이름 입력
                    System.out.println("이름을 입력하세요");
                    System.out.print(">> ");
                    final String name = scan.next();

                    // 이름이 없으면 출력
                    User userToDelete = null;
                    for (final User user : users) {
                        if (user.getName().equals(name)) {
                            userToDelete = user;
                            break;
                        }
                    }

                    if (userToDelete == null) {
                        System.out.println("이름이 없음");
                        continue;
                    }

                    // 이름을 삭제
                    users.remove(userToDelete);
                    System.out.println("삭제완료: " + userToDelete);
                }

                case "5" -> {
                    // 5.종료
                    System.out.println("5번 입력되었음");
                    System.exit(0);
                }

                default -> System.out.println("잘못된 입력입니다.");
            }
        } // while end
    } // main end
} // class end

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
