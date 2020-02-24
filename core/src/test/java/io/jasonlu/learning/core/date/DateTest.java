package io.jasonlu.learning.core.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by jiehenglu on 17/01/19.
 */
public class DateTest {

    @Test
    public void testNow() {
        System.out.println(LocalDateTime.now().getNano());
        System.out.println(new Date().getTime());
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testParseIsoDatetime() {
        String dateTimeString = "2016-01-01T01:02:03.456789";
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        assertThat(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), is(dateTimeString));
    }

    @Test
    public void testGetNanoTime() {
        String dateTimeString = "2016-01-01T01:02:03.123456789";
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        // 留意后面9位数字
        assertThat(dateTime.toLocalTime().toNanoOfDay(), is(3723123456789L));
    }

    @Test
    public void testParseUserDefinedDatetime() {
        String dateTimeString = "2016-01-01 01:02:03.123000";
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
        assertThat(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), is("2016-01-01T01:02:03.123"));
    }

    @Test
    public void testParseNanoDatetime() {
        String dateTimeString = "2016-01-01 01:02:03.123456789";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        assertThat(dateTime.format(formatter), is(dateTimeString));
    }

    @Test
    public void testParseDateOfJdk7() throws ParseException {
        String dateTimeString = "2016-01-01 01:02:03.123456789";
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS").parse(dateTimeString);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS").format(date));
    }
}
