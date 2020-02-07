package io.jasonlu.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedUserTest {

    @ParameterizedTest
    @ValueSource(strings = {"Tom", "Jack"})
    void testGetNameParameterized(String name) {
        User user = new User();
        user.setName(name);

        System.out.printf("name: %s%n", name);
        assertEquals(name, user.getName());
    }

    @ParameterizedTest
    @CsvSource(value = {"1, Tom", "2, Jack"})
    void testGetNameParameterized2(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        System.out.printf("id: %d, name: %s%n", id, name);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
    }
}
