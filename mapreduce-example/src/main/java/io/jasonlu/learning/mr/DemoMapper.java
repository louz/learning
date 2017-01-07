package io.jasonlu.learning.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Louz on 2016/3/6.
 */
public class DemoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String v = value.toString();
        System.out.printf("v====%s", v);

        String[] parts = v.split(",");
        context.write(new Text(parts[0]), new IntWritable(Integer.valueOf(parts[1])));
    }
}
