package io.jasonlu.springrestful.controller;

import com.google.gson.Gson;
import io.jasonlu.springrestful.bean.ComplexMap;
import io.jasonlu.springrestful.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by jiehenglu on 17/07/14.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mvc.xml")
@WebAppConfiguration  // 使用该注解后，可以在测试案例中获取到WebAppConfigurationContext的注入
public class RestfulControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPost() throws Exception {
        User param = new User(1, "user1");
        Gson gson = new Gson();

        // perform用于构造请求
        mockMvc.perform(post("/users/type3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gson.toJson(param))
        ).andExpect(content().string(""));

    }

    @Test
    public void testPostWithComplexMap() throws Exception {

        Map<String, String> insideMap = new HashMap<>();
        insideMap.put("1", "value1");
        insideMap.put("2", "value2");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(insideMap);

        Map<String, List<Map<String, String>>> map = new HashMap<>();
        map.put("body", list);

        ComplexMap param = new ComplexMap("id1", "user1", map);
        Gson gson = new Gson();

        // perform用于构造请求
        mockMvc.perform(post("/users/type4")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gson.toJson(param))
        ).andExpect(content().string(""));

    }
}
