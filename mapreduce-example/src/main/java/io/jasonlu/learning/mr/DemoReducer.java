package io.jasonlu.learning.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Louz on 2016/3/6.
 */
public class DemoReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int v = 0;
        for (IntWritable i : values) {
            v += i.get();
        }

        context.write(key, new IntWritable(v));
    }
}
