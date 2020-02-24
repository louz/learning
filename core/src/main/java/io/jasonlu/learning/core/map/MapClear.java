package io.jasonlu.learning.core.map;

import java.util.HashMap;
import java.util.Map;

public class MapClear {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");

        Map<String, String> map2 = map;
        map.clear();
        System.out.println(map2.size());
    }
}
