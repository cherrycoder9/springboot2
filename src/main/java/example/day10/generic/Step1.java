package example.day10.generic;

public class Step1 {
    public static void main(final String[] args) {
        // 1. 제네릭 없을때
        final Box1 box1 = new Box1();
        box1.content = "안녕하세요1";
        final String content1 = box1.content;
        System.out.println(content1);

        final Box2 box2 = new Box2();
        box2.content = 101;
        final int content2 = box2.content;
        System.out.println(content2);

        // 2.
        final Box3 box3 = new Box3();
        // 자동 타입 변환 String -> Object
        box3.content = "안녕하세요2";
        final String content3 = (String) box3.content;
        System.out.println(content3);
        // 자동 타입 변환 Object -> int
        box3.content = 102;
        final int content4 = (int) box3.content;
        System.out.println(content4);

        // 3.
        final Box4<String> box4 = new Box4<>();
        box4.content = "안녕하세요3";
        final String content5 = box4.content;
        System.out.println(content5);

        final Box4<Integer> box5 = new Box4<>();
        box5.content = 103;
        final int content6 = box5.content;
        System.out.println(content6);

    }
}
