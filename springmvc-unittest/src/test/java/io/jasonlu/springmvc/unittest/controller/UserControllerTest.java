package io.jasonlu.springmvc.unittest.controller;

import com.google.gson.Gson;
import io.jasonlu.springmvc.unittest.Config;
import io.jasonlu.springmvc.unittest.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringJUnitWebConfig(Config.class)  // 使用java代码配置时的方式
public class UserControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void testPost() throws Exception {
        User param = new User(1, "user1");
        Gson gson = new Gson();

        // perform用于构造请求
        mockMvc.perform(post("/users/type3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(param))
        ).andExpect(content().string(""));
    }
}
