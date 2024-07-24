package example.day08.thread;

import java.awt.*;

public class WorkThreadB implements Runnable {

    @Override
    public void run() {
        // 1.
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Toolkit : java.awt 자바의 UI(화면, 소리 등등) 라이브러리
        for (int i = 0; i < 5; i++) {
            // 비프음 소리출력 속도보다 for문의 5회반복 속도가 더 빨라 1번만 나오는것처럼 들린다
            // for 문을 처리하는 흐름을 잠시 일시정지
            try {
                System.out.println("띵");
                toolkit.beep();
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
