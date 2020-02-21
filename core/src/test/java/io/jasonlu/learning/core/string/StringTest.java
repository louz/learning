package io.jasonlu.learning.core.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void testFormat() {
        System.out.println(String.format("%1$10s", "."));
    }

    @Test
    public void testReplaceAll() {
        System.out.println("\\\"");

        // replacAll的两个参数都是正则表达式，正则表达式中 \\\\ 代表一个 \
        System.out.println("\\\"".replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\""));   // 输出： \\\"

        // replace的2个参数都是字符串，字符串中 \\ 代表一个 \
        System.out.println("\\\"".replace("\\", "\\\\").replace("\"", "\\\""));                 // 输出： \\\"
    }
}
