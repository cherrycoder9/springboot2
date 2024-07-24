package example.day08.thread;

import java.awt.*;

public class Step1 {
    public static void main(final String[] args) throws InterruptedException {

        System.out.println("========== 싱글 쓰레드 ==========");
        // 1.
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Toolkit : java.awt 자바의 UI(화면, 소리 등등) 라이브러리
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            // 비프음 소리출력 속도보다 for문의 5회반복 속도가 더 빨라 1번만 나오는것처럼 들린다
            // for 문을 처리하는 흐름을 잠시 일시정지
            System.out.println("띵");
            Thread.sleep(1000);
        }

        // 2.
        for (int i = 0; i < 5; i++) {
            System.out.println("소리출력");
            Thread.sleep(1000);
        }

        // ========== 멀티 쓰레드 1 ================
        System.out.println("========== 멀티 쓰레드 1 ==========");
        // 1. 작업스레드 A의 객체 생성
        final WorkThreadA threadA = new WorkThreadA();
        // 2. 작업스레드 A의 스레드 실행 (run 메소드 실행)
        threadA.start();

        // 2.
        for (int i = 0; i < 5; i++) {
            System.out.println("소리출력");
            Thread.sleep(1000);
        } // for end

        // ========== 멀티 쓰레드 2 ================
        System.out.println("========== 멀티 쓰레드 2 ==========");
        // 1. 구현객체 생성
        final Runnable runnable1 = new WorkThreadB();
        // 2. Thread 객체
        final Thread threadB = new Thread(runnable1);
        // 3. 스레드 실행
        threadB.start();
        // 2.
        for (int i = 0; i < 5; i++) {
            System.out.println("소리출력");
            Thread.sleep(1000);
        } // for end

        // ========== 멀티 쓰레드 3 ================
        System.out.println("========== 멀티 쓰레드 3 ==========");
        // 익명 객체/구현체 : 이름 없는 객체
        // 1. (익명) 구현 객체 생성
        final Thread threadC = new Thread() {
            @Override
            public void run() {
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
            } // run end
        }; // 익명구현체 end

        // 2. ThreadC 실행
        threadC.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("소리출력");
            Thread.sleep(1000);
        } // for end

        // ========== 멀티 쓰레드 4 ================
        System.out.println("========== 멀티 쓰레드 4 ==========");
        final Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                final Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("띵");
                        toolkit.beep();
                        Thread.sleep(1000);
                    } catch (final InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        // 2. ThreadD 실행
        threadD.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("소리출력");
            Thread.sleep(1000);
        }
    } // method end
} // class end
