package com.jin.Ex13;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, LongWritable, Text, LongWritable>{
//	@Override
//	protected void reduce(Text key, Iterable<IntWritable> values,
//			Reducer<Text, IntWritable, Text, IntWritable>.Context ctx) throws IOException, InterruptedException {
//		int cnt=0;
//		
//		for(IntWritable v : values)
//			cnt += v.get();
//		
//		ctx.write(key, new IntWritable(cnt));
//	}
	@Override
	protected void reduce(Text key, Iterable<LongWritable> values,
			Reducer<Text, LongWritable, Text, LongWritable>.Context ctx) throws IOException, InterruptedException {
		Long cnt=0L;
		
		for(LongWritable v : values)
			cnt += v.get();
		
		ctx.write(key, new LongWritable(cnt));
	}
}













