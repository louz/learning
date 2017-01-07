package io.jasonlu.learning.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Louz on 2016/3/6.
 */
public class MapperTest {

    @Test
    public void testMapper() throws IOException {
        Mapper demoMapper = new DemoMapper();
        MapDriver mapDriver = MapDriver.newMapDriver(demoMapper);

        mapDriver
                .withInput(new LongWritable(0), new Text("1234,56789"))
                .withOutput(new Text("1234"), new IntWritable(56789))
                .runTest();
    }
}
