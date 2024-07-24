package example.practice.threadtest1;

public class Test1 {
    public static void main(final String[] args) throws InterruptedException {
        // 1부터 100만의 각 숫자를 2를 곱한 다음에 3을 나누어 ArrayList로 추가하는 프로그램
        // 싱글 스레드와 멀티스레드의 동작 시간을 측정해 콘솔 출력함

        // 1 - 싱글스레드 성능 측정 시작
        final long singleThreadStart = System.currentTimeMillis();
        final SingleThread st = new SingleThread(1, 1000000000);
        st.startCalc();
        System.out.println("싱글스레드 더하기 결과: " + st.getSum());
        final long singleThreadEnd = System.currentTimeMillis();
        System.out.println("싱글스레드 작업시간: " + (singleThreadEnd - singleThreadStart) + " ms");

        // 2 - 멀티스레드 성능 측정 시작
        final long multiThreadStart = System.currentTimeMillis();
        final MultiThread mt1 = new MultiThread(1, 200000000);
        final MultiThread mt2 = new MultiThread(200000001, 400000000);
        final MultiThread mt3 = new MultiThread(400000001, 600000000);
        final MultiThread mt4 = new MultiThread(600000001, 800000000);
        final MultiThread mt5 = new MultiThread(800000001, 1000000000);
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
        mt1.join();
        mt2.join();
        mt3.join();
        mt4.join();
        mt5.join();
        final long totalSum = MultiThread.getTotalSum();
        System.out.println("멀티스레드 더하기 결과: " + totalSum);
        final long multiThreadEnd = System.currentTimeMillis();
        System.out.println("멀티스레드 작업시간: " + (multiThreadEnd - multiThreadStart) + " ms");

        // 3 - 동기화 멀티스레드 성능 측정 시작
        final long syncMultiThreadStart = System.currentTimeMillis();
        final SyncMultiThread smt1 = new SyncMultiThread(1, 200000000);
        final SyncMultiThread smt2 = new SyncMultiThread(200000001, 400000000);
        final SyncMultiThread smt3 = new SyncMultiThread(400000001, 600000000);
        final SyncMultiThread smt4 = new SyncMultiThread(600000001, 800000000);
        final SyncMultiThread smt5 = new SyncMultiThread(800000001, 1000000000);
        smt1.start();
        smt2.start();
        smt3.start();
        smt4.start();
        smt5.start();
        smt1.join();
        smt2.join();
        smt3.join();
        smt4.join();
        smt5.join();
        final long totalSum2 = SyncMultiThread.getTotalSum();
        System.out.println("동기화 멀티스레드 더하기 결과: " + totalSum2);
        final long syncMultiThreadEnd = System.currentTimeMillis();
        System.out.println("동기화 멀티스레드 작업시간: " + (syncMultiThreadEnd - syncMultiThreadStart) + " ms");
    }
}
