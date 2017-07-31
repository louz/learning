package io.jasonlu.learning.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by louz on 2016/9/20.
 */
public class DriverTest {

    @Test
    public void test() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "file:///");
        conf.set("mapreduce.framework.name", "local");
        conf.setInt("mapreduce.task.io.sort.mb", 1);

//        Path input = new Path("d:/tmp/input");
        Path input = new Path("/Users/jiehenglu/tmp/input");


//        Path output = new Path("d:/tmp/output");
        Path output = new Path("/Users/jiehenglu/tmp/output");
        FileSystem fs = FileSystem.getLocal(conf);
        fs.delete(output, true); // delete old output

        DemoDriver driver = new DemoDriver();
        driver.setConf(conf);
        int exitCode = driver.run(new String[]{
                input.toString(), output.toString()});
        assertThat(exitCode, is(0));
//        checkOutput(conf, output);
    }
}
