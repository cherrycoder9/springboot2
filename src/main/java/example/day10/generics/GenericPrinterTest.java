package example.day10.generics;

// 테스트 클래스
public class GenericPrinterTest {
    public static void main(final String[] args) {
        // Powder 타입의 GenericPrinter 객체 생성
        final GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        // Powder 객체를 설정
        powderPrinter.setMaterial(new Powder());
        // 설정된 Powder 객체를 가져옴
        final Powder powder = powderPrinter.getMaterial();
        // GenericPrinter 객체의 toString() 메서드 호출 (Powder의 toString() 호출)
        System.out.println(powderPrinter);

        // Plastic 타입의 GenericPrinter 객체 생성
        final GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        // Plastic 객체를 설정
        plasticPrinter.setMaterial(new Plastic());
        // 설정된 Plastic 객체를 가져옴
        final Plastic plastic = plasticPrinter.getMaterial();
        // GenericPrinter 객체의 toString() 메서드 호출 (Plastic의 toString() 호출)
        System.out.println(plasticPrinter);

        // GenericPrinter 객체의 doPrinting() 메서드 호출
        plasticPrinter.doPrinting();
        powderPrinter.doPrinting();

    }
}
