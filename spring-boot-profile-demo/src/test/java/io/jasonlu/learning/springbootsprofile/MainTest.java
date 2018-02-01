package io.jasonlu.learning.springbootsprofile;

import io.jasonlu.learning.springbootsprofile.service.MyService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

/**
 * Created by jiehenglu on 17/07/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Config.class})
@ActiveProfiles("profile1")
public class MainTest {

    @Autowired
    private MyService service;

    @Test
    public void testActiveProfile() {
        assertThat(service.hello(), Is.is("Service1"));
    }
}
