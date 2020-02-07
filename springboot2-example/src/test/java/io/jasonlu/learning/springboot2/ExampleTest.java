package io.jasonlu.learning.springboot2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * 该类主要时演示如何编写单元测试案例
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ExampleTest {

    @Test
    public void testHello(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/demo")
            .param("key1", "value1")
        ).andExpect(content().string("Hello value1 !"));
    }
}
