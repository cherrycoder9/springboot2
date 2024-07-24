package example.day04;

public class Step1 {
    public static void main(String[] args) {
        // [1] 문자열 선언하는 두 가지 방법
        // [힙영역], 302번지 참조 --> 상수풀 참조
        String str1 = new String("abc");
        // 상수풀[메소드영역], 상수풀 참조
        String str2 = "abc";
        // 상수풀[메소드영역], 상수풀 참조
        String str3 = "abc";
        // [힙영역], 402번지 참조 --> 상수풀 참조
        String str4 = new String("abc");
        String str5 = "abc";

        System.out.println(str2 == str3); // true
        System.out.println(str2.equals(str3)); // true
        System.out.println(str1 == str4); // false
        System.out.println(str1.equals(str4)); // true

        // [2] 두 문자열 연결하는 방법
        // [2-1]. 문자열1.concat(문자열2): 두 문자열을 연결한 새로운 문자열 반환 함수
        String javaStr = new String("java");
        String androidStr = new String("android");
        System.out.println(System.identityHashCode(javaStr));
        javaStr = javaStr.concat(androidStr);
        System.out.println(javaStr);
        System.out.println(System.identityHashCode(javaStr));

        // [2-2] 문자열1 += 문자열2: += 변수 : 변수 + 값
        String html1 = "<div>";
        String html2 = "하하</div>";
        System.out.println(System.identityHashCode(html1));
        html1 += html2;
        System.out.println(html1);
        System.out.println(System.identityHashCode(html1));

        // [2-3]
        String javaStr2 = new String("Java");
        String androidStr2 = new String("Android");
        System.out.println(System.identityHashCode(javaStr2));

        // 스트링버퍼 및 스트링빌더는 문자열 결합시 주소값이 변경되지 않는다.
        StringBuilder buffer = new StringBuilder(javaStr2);
        System.out.println(">> [3]연결 전1: " + System.identityHashCode(buffer));
        buffer.append(androidStr2);
        System.out.println(">> [3]연결 후1: " + System.identityHashCode(buffer));

        javaStr2 = javaStr2 + androidStr2;

        System.out.println(javaStr2);
        System.out.println(System.identityHashCode(javaStr2));
    }
}
