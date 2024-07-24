package example.day09.thread;

public class User1 extends Thread {
    Calculator calc;
    int value;

    @Override
    public void run() {
        try {
            calc.setMemory(value);
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(final int value) {
        this.value = value;
    }
}
