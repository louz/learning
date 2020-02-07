package io.jasonlu.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @DisplayName("第一个测试")
    @Test
    void getName1() {
        User user = new User();
        user.setName("Tom");

        assertEquals("Tom", user.getName());
    }

    @DisplayName("第二个测试")
    @Test
    void getName2() {
        User user = new User();
        user.setName("Jack");

        assertEquals("Jack", user.getName());
    }

    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }
}