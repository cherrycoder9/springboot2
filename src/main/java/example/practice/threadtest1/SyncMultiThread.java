package example.practice.threadtest1;

import lombok.Getter;

@Getter
public class SyncMultiThread extends Thread {
    public static long totalSum = 0; // 공유
    private int startNum;
    private int endNum;

    public SyncMultiThread() {

    }

    public SyncMultiThread(final int startNum, final int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    private static synchronized void addToTotalSum(final long sum) {
        totalSum += sum;
    }

    static synchronized long getTotalSum() {
        return totalSum;
    }

    @Override
    public synchronized void run() {
        startCalc();
    }

    public synchronized void startCalc() {
        long sum = 0;
        for (int i = startNum; i <= endNum; i++) {
            sum += ((i * 2L / 3) % 101);
        }
        addToTotalSum(sum);
    }
}
