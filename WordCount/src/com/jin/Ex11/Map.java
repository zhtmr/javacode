package com.jin.Ex11;

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

		// hadoop jar jar파일 메소드명 -D optSelect=설정명 입력 출력
		optSelect = context.getConfiguration().get("optSelect");
	}
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		AirlineParser parser = new AirlineParser(value);
		int delay=0;
		// 항공사별 도착,출발 지연시간
		if("dep".equalsIgnoreCase(optSelect)) delay=parser.getDepDelay();
		else if("arr".equalsIgnoreCase(optSelect)) delay=parser.getArrDelay();
		
		if(delay>0)
			context.write(new Text(parser.getUniqueCarrier()), new IntWritable(1));
		
		
	}
	
}


