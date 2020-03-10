package io.jasonlu.learning.core.constructor;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jiehenglu on 17/01/26.
 */
public class ConstructorTest {

    @Test
    public void test() {
        MyConstructBean b = new MyConstructBean(20);
        assertThat(b.get(), Is.is(20));
    }
}
