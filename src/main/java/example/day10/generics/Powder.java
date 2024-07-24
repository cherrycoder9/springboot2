package example.day10.generics;

// 파우더 재료 클래스
public class Powder extends Material {
    // 파우더 재료로 출력한다는 메시지를 출력하는 메서드
    @Override
    public void doPrinting() {
        System.out.println("파우더 재료로 출력합니다.");
    }

    // 객체를 문자열로 표현하는 메서드
    @Override
    public String toString() {
        return "재료는 파우더입니다.";
    }
}
