package io.jasonlu.learning.core.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewAndPut {

    private static Map<String, String> map = new HashMap<>();
    private static Map<String, String> allMap = new HashMap<>();
    private final static Object lock = new Object();

    public static void main(String[] args) {


        new Thread(() -> {
            int size = 0;
            long start = System.currentTimeMillis();

            while (size < 1000000) {
                Map<String, String> localMap;
                synchronized (lock) {
                    allMap.putAll(map);
                    map.clear();
                    localMap = map;
//                    map = new HashMap<>();
                }

//                allMap.putAll(localMap);
                size = allMap.size();
                System.out.println(String.format("allMap size: %d", size));
                Thread.yield();
            }

            System.out.println(String.format("used time: %f", (System.currentTimeMillis() - start) / 1000.0));
        }).start();

        int i = 0;
        while (i < 1000000) {
            String keyAndValue = String.format("%d", i++);
            synchronized (lock) {
                map.put(keyAndValue, keyAndValue);
            }
//            System.out.println(String.format("i: %d", i));
            Thread.yield();
        }
    }
}
