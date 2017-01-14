package io.jasonlu.json;

import com.google.gson.Gson;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jiehenglu on 17/01/12.
 */
public class GsonTest {
    @Test
    public void testSimpleDeserialized() {
        String json = "{\"name\": \"abc\", \"value\": 1}";
        User user = new Gson().fromJson(json, User.class);

        User expected = new User("abc", 1);
        assertThat(user, is(expected));
    }

    @Test
    public void testAliasColNameDeserialized() {
        String json = "{\"name\": \"abc\", \"v\": 1}";
        User2 user = new Gson().fromJson(json, User2.class);

        User2 expected = new User2("abc", 1);
        assertThat(user, is(expected));
    }
}
