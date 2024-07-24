package example.day10.p400;

// 두 개의 제네릭 타입 T와 V를 사용하는 Point 클래스
public class Point<T, V> {
    // T 타입의 x 좌표
    T x;
    // V 타입의 y 좌표
    V y;

    // 생성자: x와 y 좌표를 초기화
    public Point(final T x, final V y) {
        this.x = x;
        this.y = y;
    }

    // x 좌표를 반환하는 getter 메서드
    public T getX() {
        return x;
    }

    // y 좌표를 반환하는 getter 메서드
    public V getY() {
        return y;
    }
}
