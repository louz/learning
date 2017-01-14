package io.jasonlu.javabasic;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jiehenglu on 17/01/12.
 */
public class DateTest {
    @Test
    public void testDateTimeParse() throws ParseException {

        // JDK 8 可解析到纳米级别
        String dateTimeInJdk8 = "2012-12-12 01:01:01.123456";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInJdk8, dateTimeFormatter);
        assertThat(dateTime.format(dateTimeFormatter), is(dateTimeInJdk8));

        // JDK 7 只能解析到毫秒级别
        String dateTimeInJdk7 = "2012-12-12 01:01:01.123";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = dateFormat.parse(dateTimeInJdk7);
        assertThat(dateFormat.format(date), is(dateTimeInJdk7));
    }
}
