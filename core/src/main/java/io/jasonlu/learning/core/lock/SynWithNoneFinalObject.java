package io.jasonlu.learning.core.lock;

import java.util.Map;

public class SynWithNoneFinalObject {

    private static Object noneFinalLock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            int count = 0;
            while (count < 1000000) {
                Map<String, String> localMap;

                // 如果没有里面那句noneFinalLock = new Object()，含有before和after的2句会连续打印；
                // 但如果有了那句noneFinalLock = new Object()，before和after 2句之间可能会出现主线程的打印语句
                synchronized (noneFinalLock) {
                    System.out.printf("in syn before lock change, count: %d%n", count);
                    noneFinalLock = new Object();  // 在这里生成了新的lock对象，就类似把锁释放了
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("in syn after lock change, count: %d%n", count);

                    count++;
                }
                Thread.yield();
            }
        }).start();

        // 主线程中，循环打印i
        int i = 0;
        while (i < 1000000) {
            synchronized (noneFinalLock) {
                System.out.printf("in main thread, %d%n", i++);
            }
            Thread.yield();
        }
    }
}
