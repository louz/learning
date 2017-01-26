package io.jasonlu.learning.core.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiehenglu on 17/01/25.
 */
public class GenericMethod {
    public static <K, V> Map<K, V> newMap() {
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        Map<String, String> sMap = newMap();
        System.out.println(sMap.getClass());

        Map<String, Integer> siMap = newMap();
        System.out.println(siMap.getClass());
    }
}
