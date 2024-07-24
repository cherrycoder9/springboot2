package example.day09.thread;

public class Step1 {
    public static void main(final String[] args) throws InterruptedException {
        // 1. 현재 코드를 실행하는 스레드의 이름 호출
        final Thread thread = Thread.currentThread();
        System.out.println("해당 코드를 읽고 있는 스레드명" + thread.getName());

        // 2. 여러개의 스레드를 만들어서 스레드 이름 확인
        for (int i = 0; i < 5; i++) {
            final Thread threadA = new Thread() {
                @Override
                public void run() {
                    final Thread thread = Thread.currentThread();
                    // thread.setName("내가 만든 작업스레드"); // 스레드 이름 정의하기
                    System.out.println("해당 코드를 읽고 있는 스레드명" + thread.getName());
                } // run end
            }; // constructor end
            threadA.start(); // thread start
        } // for end

        // 3. 현재 스레드를 주어진 시간동안 일시정지
        System.out.println("======= 2초간 대기중 ========");
        Thread.sleep(2000);
        System.out.println("======= 2초 이후 ========");

        // 4. 서로 다른 스레드의 종료를 기다림
        final SumThread sumThread = new SumThread();
        sumThread.start();

        // sumThread.start(); 시작 이후 바로 내려와서 합계는 0 나옴
        System.out.println("join 이전 합계 결과: " + sumThread.getSum());

        // main 스레드가 SumThread 종료될 때까지 기다림
        sumThread.join();

        System.out.println("join 이후 합계 결과: " + sumThread.getSum());

        // 5. 다른 스레드의 순서를 양보
        final WorkThread workThreadA = new WorkThread();
        workThreadA.setName("작업스레드A");
        final WorkThread workThreadB = new WorkThread();
        workThreadB.setName("작업스레드B");
        workThreadA.start();
        workThreadB.start();
        Thread.sleep(3000);
        // WorkThread.java 에서 yield 처리 되어있어서 다른 스레드에게 양보
        workThreadA.work = false;
        Thread.sleep(3000);
        workThreadA.work = true;

    } // main end
} // class end
