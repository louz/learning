package io.jasonlu.learning.core.generic;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by jiehenglu on 17/01/25.
 */
public class ConcreteTest {
    @Test
    public void testGetGenericArgType() {
        Concrete c = new Concrete();
        assertThat(c.getClazzName(), CoreMatchers.is(String.class.getTypeName()));
    }
}
