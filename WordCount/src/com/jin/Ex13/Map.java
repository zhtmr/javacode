package com.jin.Ex13;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
	private String optSelect;
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		optSelect = context.getConfiguration().get("optSelect");
	}
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		AirlineParser parser = new AirlineParser(value);
		if(parser.getDistance()>0) {
			context.write(new Text("Distance_all"), 
					new IntWritable(parser.getDistance()));
			context.getCounter(DistanceCnt.nonZeroCnt).increment(1);
		}else
			context.getCounter(DistanceCnt.zeroCnt).increment(1);
	}
}













