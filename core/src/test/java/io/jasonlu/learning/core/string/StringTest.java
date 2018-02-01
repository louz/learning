package io.jasonlu.learning.core.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void testFormat() {
        System.out.println(String.format("%1$10s", "."));
    }
}
