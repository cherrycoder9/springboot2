package example.day09.thread;

public class WorkThread extends Thread {
    public boolean work = true;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                throw new RuntimeException(e);
            } // catch end

            if (work) {
                System.out.println(getName());
            } else {
                Thread.yield();
            } // end if
        } // while end
    } // run end
} // class end
