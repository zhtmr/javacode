package com.jin.Ex11;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context ctx) throws IOException, InterruptedException {
		int cnt=0;
		for(IntWritable v: values)
			cnt+=v.get();
		
		// Ç×°ø»ç, ÃÑÈ½¼ö
		ctx.write(key, new IntWritable(cnt));
		
	}

}
