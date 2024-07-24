package example.day08.thread;

import java.util.Scanner;

public class Step2 {
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        // 1. Thread 객체 생성
        final DigitalTime digitalTime = new DigitalTime();
        // 2. Thread 실행
        digitalTime.start();

        Timer timer = null;
        while (true) {
            System.out.println("[1]start [2]stop [3]exit");
            final int ch = scan.nextInt();
            if (ch == 1) {
                timer = new Timer();
                final Thread thread = new Thread(timer);
                thread.start();
            } else if (ch == 2) {
                if (timer != null) {
                    timer.state = false;
                }
            } else if (ch == 3) {
                System.exit(0);
            }
        } // while end
    } // main end
} // class end
