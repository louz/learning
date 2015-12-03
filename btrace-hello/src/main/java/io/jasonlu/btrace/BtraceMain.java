package io.jasonlu.btrace;

/**
 * Created by Louz on 2015/11/6.
 */
public class BtraceMain {
    public static void main(String[] args) throws InterruptedException {
        BtraceMain m = new BtraceMain();
        int i = 0;
        while (true) {
            m.run(i++);
            Thread.sleep(1000);
        }
    }

    private void run(int i) {
        System.out.println("i = " + i);
    }
}
