package io.jasonlu.learning.core.constructor;

/**
 * Created by jiehenglu on 17/01/26.
 */
public class MyConstructBean {
    private final int value;

    public MyConstructBean(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
