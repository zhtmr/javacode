package com.jin.Ex15;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		AirlineParser parser = new AirlineParser(value);
		
		// dep:항공사,1
		if(parser.getDepDelay()>0)
			context.write(new Text("dep:"+parser.getUiqueCarrier()), 
					new IntWritable(1));
		// arr:항공사,1
		if(parser.getArrDelay()>0)
			context.write(new Text("arr:"+parser.getUiqueCarrier()), 
					new IntWritable(1));
	}
}













