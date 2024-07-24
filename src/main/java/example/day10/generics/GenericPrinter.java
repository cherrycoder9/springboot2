package example.day10.generics;

// T라는 제네릭 타입을 사용하는 클래스
public class GenericPrinter<T extends Material> {
    // T 타입의 멤버 변수 material
    private T material;

    // material을 반환하는 getter 메서드
    public T getMaterial() {
        return material;
    }

    // material을 설정하는 setter 메서드
    public void setMaterial(final T material) {
        this.material = material;
    }

    // material의 doPrinting() 메서드를 호출
    public void doPrinting() {
        material.doPrinting();
    }

    // material의 toString() 메서드를 호출하여 문자열로 반환
    @Override
    public String toString() {
        return material.toString();
    }
}
