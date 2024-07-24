package example.day10.p400;

// 제네릭 메서드를 포함하는 클래스
public class GenericMethod {
    // 제네릭 메서드: 두 개의 Point 객체를 사용하여 사각형의 넓이를 계산
    public static <T, V> double makeRectangle(final Point<T, V> p1, final Point<T, V> p2) {
        // p1의 x 좌표를 Number로 캐스팅하여 double 값으로 변환
        final double left = ((Number) p1.getX()).doubleValue();
        // p2의 x 좌표를 Number로 캐스팅하여 double 값으로 변환
        final double right = ((Number) p2.getX()).doubleValue();

        // p1의 y 좌표를 Number로 캐스팅하여 double 값으로 변환
        final double top = ((Number) p1.getY()).doubleValue();
        // p2의 y 좌표를 Number로 캐스팅하여 double 값으로 변환
        final double bottom = ((Number) p2.getY()).doubleValue();

        // 사각형의 너비 계산
        final double width = right - left;
        // 사각형의 높이 계산
        final double height = bottom - top;

        // 사각형의 넓이 반환
        return width * height;
    }

    // main 메서드: 프로그램 실행 진입점
    public static void main(final String[] args) {
        // Integer 타입의 x 좌표와 Double 타입의 y 좌표를 가지는 Point 객체 p1 생성
        final Point<Integer, Double> p1 = new Point<>(0, 0.0);
        // Integer 타입의 x 좌표와 Double 타입의 y 좌표를 가지는 Point 객체 p2 생성
        final Point<Integer, Double> p2 = new Point<>(10, 10.0);

        // p1과 p2로 만들어진 사각형의 넓이를 계산
        final double rect = GenericMethod.makeRectangle(p1, p2);
        // 계산된 사각형의 넓이를 출력
        System.out.println("두 점으로 만들어진 사각형의 넓이는 = " + rect + "입니다.");
    }
}
