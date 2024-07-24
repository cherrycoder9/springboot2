package example.day03;

class Book { // 직접 extends Object 하지 않아도 자동으로 Object 클래스로부터 상속받는다
    // 멤버변수
    int bookNumber;
    String bookTitle;

    // 생성자
    public Book(int bookNumber, String bookTitle) {
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
    } // 생성자 end

    @Override
    public String toString() {
        return "Book [bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + "]";
    }
} // Book 클래스 end

public class Step1 {
    public static void main(String[] args) {
        // 1. 객체 생성
        // 스택메모리: book1 = 힙메모리: 302번지 객체 생성
        Book book1 = new Book(200, "개미");
        // 2. Book 클래스의 메소드가 아닌 Object 클래스의 메소드 호출
        System.out.println(book1);

        // 3. 객체2 생성
        // 스택메모리: book2 = 힙메모리: 402번지 객체 생성
        Book book2 = new Book(200, "Tiger");
        // 4. 객체3 생성
        // 스택메모리: book3 = 힙메모리: 502번지 객체 생성
        Book book3 = new Book(200, "ANT"); // 객체1 멤버변수 동일하게 생성
        // 5. 객체4 생성이 아닌 객체 참조
        // 스택메모리: book4 = book1(302번지 참조)
        Book book4 = book1;

        System.out.println(book1 == book2); // false
        System.out.println(book1 == book3); // false
        System.out.println(book1 == book4); // true

        System.out.println(book1.equals(book2)); // false
        System.out.println(book1.equals(book3)); // false
        System.out.println(book1.equals(book4)); // true

    }
}
