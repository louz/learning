package io.jasonlu.learning.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Louz on 2016/3/6.
 */
public class ReducerTest {

    @Test
    public void testReducer() throws IOException {
        DemoReducer demoReducer = new DemoReducer();
        ReduceDriver reduceDriver = ReduceDriver.newReduceDriver(demoReducer);
        reduceDriver
                .withInput(new Text("1234"), Arrays.asList(new IntWritable(1), new IntWritable(2)))
                .withOutput(new Text("1234"), new IntWritable(3))
                .runTest();
    }
}
