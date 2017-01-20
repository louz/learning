package io.jasonlu.learning.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by jiehenglu on 17/01/19.
 */
public class DateTest {
    @Test
    public void testParseIsoDatetime() {
        String dateTimeString = "2016-01-01T01:02:03.456789";
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        assertThat(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), is(dateTimeString));
    }

    @Test
    public void testGetNanoTime() {
        String dateTimeString = "2016-01-01T01:02:03.456789";
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        assertThat(dateTime.toLocalTime().toNanoOfDay(), is(3723456789000L));
    }
}
