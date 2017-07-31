package io.jasonlu.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.time.LocalDate;

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

        User expected = new User();
        expected.setName("abc");
        expected.setValue(1);
        assertThat(user, is(expected));
    }

    @Test
    public void testAliasColNameDeserialized() {
        String json = "{\"name\": \"abc\", \"v\": 1}";
        User2 user = new Gson().fromJson(json, User2.class);

        User2 expected = new User2("abc", 1);
        assertThat(user, is(expected));
    }

    @Test
    public void testAliasColNameDeserialized2() {
        String json = "{\"name\": \"abc\", \"v1\": 1}";
        User2 user = new Gson().fromJson(json, User2.class);

        User2 expected = new User2("abc", 1);
        assertThat(user, is(expected));

        System.out.println(new Gson().toJson(user));
    }

    @Test
    public void testLocalDateSeDes() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

        String json = "{\"name\":\"Tom\", \"birth\": \"2010-01-01\"}";
        User user = gson.fromJson(json, User.class);

        User expected = new User();
        expected.setName("Tom");
        expected.setBirth(LocalDate.parse("2010-01-01"));

        assertThat(user, is(expected));
    }
}
