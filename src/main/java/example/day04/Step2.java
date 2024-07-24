package example.day04;

import java.util.Arrays;
import java.util.Random;

public class Step2 {
    public static void main(String[] args) {
        // 문자열에서 자주 사용되는 함수
        // [1] 문자열.charAt(인덱스): 해당 인덱스 번호의 문자 1개 추출
        String ssn = "012312-1230123";
        char gender = ssn.charAt(7);
        switch (gender) {
            case '1':
            case '3':
                System.out.println("남자");
                break;
            case '2':
            case '4':
                break;
        }
        // 활용: Scanner에서 문자 입력 메소드가 없다.
        // Scanner scan = new Scanner(System.in);
        // char _char = scan.next().charAt(0); // 문자 1개 입력
        // System.out.println("_char = " + _char);

        // [2] 문자열.length() : 문자열의 길이 반환 함수
        System.out.println(ssn.length());
        // 활용: for 문과 활용하면 문자 1개씩 순회
        for (int i = 0; i < ssn.length(); i++) {
            System.out.println(ssn.charAt(i)); // 문자열 내 i번째 인덱스의 문자 1개씩 출력
        }

        // [3] 문자열.replace(기존문자열, 변경할문자열);
        // 문자열내 기존문자열이 존재하면 변경할 문자열로 치환/교체 된 새로운 문자열 반환
        String oldStr = "자바의 문자열은 불변입니다. 자바 문자열은 String 입니다.";
        String newStr = oldStr.replace("자바", "Java"); // 자바 --> JAVA 치환/교체
        System.out.println("oldStr = " + oldStr);
        System.out.println("newStr = " + newStr);
        // 활용: 서로 다른 언어들간의 문법 치환/교체, HTML 줄바꿈 <br/> 자바는 \n or %n
        String htmlStr = "안녕하세요<br/>유재석";
        System.out.println("htmlStr = " + htmlStr);
        String javaStr = htmlStr.replace("<br/>", "\n");
        System.out.println("javaStr = " + javaStr);

        // [4] 문자열.subString(시작인덱스, [끝인덱스]): 문자열을 인덱스 기준으로 잘라낸 새로운 문자열 반환
        // ssn = 246673-1426096;
        String firstNum = ssn.substring(0, 6); // 0번 인덱스부터 6번 인덱스 전까지 추출
        System.out.println("firstNum = " + firstNum);

        // [5] 문자열.split("구분문자") 문자열 분해해서 새로운 문자열 배열 반환
        // 인덱스 기준으로 자를때 많이 사용
        String[] strArray = ssn.split("-"); // "-" 기준으로 문자열 분해
        // System.out.println(strArray); // 해당 배열의 요소들의 값들을 문자열로 반환
        System.out.println("Arrays.toString(strArray) = " + Arrays.toString(strArray));
        System.out.println("[0] : " + strArray[0]); // [0] : 012312
        System.out.println("[1] : " + strArray[1]); // [1] : 1230123
        // 활용: CSV 형식의 문자열 다룰때 많이 사용
        String csvStr = "유재석,80,90,100\n강호동,60,80,90\n신동역,90,60,80";
        // 행 구분자인 \n 기준으로 분해해서 배열로 받기
        String[] rowsStr = csvStr.split("\n");
        System.out.println(Arrays.toString(rowsStr));
        // 열 구분자인 , 기준으로 분해해서 배열로 받기
        for (int i = 0; i < rowsStr.length; i++) {
            String[] colsStr = rowsStr[i].split(",");
            System.out.println(Arrays.toString(colsStr));
            for (int j = 0; j < colsStr.length; j++) {
                System.out.println(colsStr[j]);
            }
        }

        // [6] 문자열.indexOf() : 문자열 내 찾을 문자가 존재하면 찾은 문자열의 인덱스 반환, 없으면 -1 반환
        String subject = "자바 프로그래밍 언어";
        int findIndex = subject.indexOf("프로");
        System.out.println("findIndex = " + findIndex); // 3

        // [7] 문자열.contains() : 문자열 내 찾을 문자가 존재하면 true 반환 없으면 false 반환
        boolean findCheck = subject.contains("자바");
        System.out.println("findCheck = " + findCheck); // 자바: true, 프로: true, 파이썬: false

        // [8] 문자열.getBytes   : 문자열 내 문자 하나씩 바이트로 변환된 바이트 배열로 반환
        byte[] bytes = subject.getBytes();
        System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));

        // 문자char와 바이트의 관계
        // 1. 영문/특정 특수문자: 문자 1개당 1바이트
        // 2. 한글: 문자1개당 2바이트 + 규칙1바이트 => 총 3바이트
        byte _byte1 = 'a';
        System.out.println("_byte1 = " + _byte1);
        _byte1++;
        System.out.println("_byte1 = " + _byte1);
        System.out.println("(char)_byte1 = " + (char) _byte1);

        System.out.println("a".length());
        System.out.println("가".length());
        System.out.println("a".getBytes().length); // 배열은 length 소괄호를 안씀
        System.out.println("가".getBytes().length);
        // char: 문자 1개 표현, 65536글자 표현
        // 부호:signed 부호없음:unsigned
        char _char = '가';
        System.out.println("_char = " + _char); // 가
        System.out.println("(int)_char = " + (int) _char); // 44032

        char _char2 = 'a';
        System.out.println("(int)_char2 = " + (int) _char2);

        // 활용
        String newPwd = "";
        for (int i = 0; i < 10; i++) {
            newPwd += (char) (new Random().nextInt(26) + 97);
            System.out.println(newPwd);
        }
    } // main end
} // class end
