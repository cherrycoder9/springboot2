package example.day09.thread;

public class Step2 {
    public static void main(final String[] args) {

        // 1. 계산기 객체
        final Calculator mycal = new Calculator();

        // 2. 유저 객체
        final User1 user1 = new User1();
        user1.setName("User1 Thread");
        // 유저 필드의 계산기 객체 대입
        user1.calc = mycal;
        user1.setValue(100);
        user1.start();

        // 3. 유저 객체
        final User1 user2 = new User1();
        user2.setName("User2 Thread");
        // user1, user2 객체 내 동일한 필드 값 대입
        user2.calc = mycal;
        user2.setValue(200);
        user2.start();
    }
}
