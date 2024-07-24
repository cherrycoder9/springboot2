package example.day09.thread;

public class Calculator {
    int memory;

    public synchronized void setMemory(final int memory) throws InterruptedException {
        System.out.println("memory = " + memory);
        // 매개변수 값을 필드 저장
        this.memory = memory;
        // 2초간 일시 정지
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName());
        // 현재 매개변수 확인
        System.out.println(this.memory);
    }
}
