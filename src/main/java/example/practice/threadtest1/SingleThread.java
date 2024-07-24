package example.practice.threadtest1;

import lombok.Getter;

@Getter
public class SingleThread {
    private int startNum;
    private int endNum;
    private long sum;

    public SingleThread() {

    }

    public SingleThread(final int startNum, final int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public void startCalc() {
        for (int i = startNum; i <= endNum; i++) {
            this.sum += ((i * 2L / 3) % 101);
        }
    }
}
