package io.jasonlu.learning.core.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        System.out.println("{{project_name}}".replaceAll("\\{\\{project_name\\}\\}", "aa"));
    }

    @Test
    public void testReplaceFirst() {
        String url = "aaa.domain.com";

        String newUrl = url.replaceFirst("\\w*\\.", "route.");
        assertEquals("route.domain.com", newUrl);
    }

    @Test
    public void testFormatNumber() {
        assertEquals("001", String.format("%03d", 1));
    }
}
