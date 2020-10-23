package com.jin.Ex13;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, LongWritable>{
	private String optSelect;
	
	// setup 함수는 태스크 내에서 공용으로 사용될 변수를 초기화하거나 또는 hadoop query에 인자로 넘겨 받은 전역 변수를 불러오는데 사용될 수 있다.
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		optSelect = context.getConfiguration().get("optSelect");
	}
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		AirlineParser parser = new AirlineParser(value);
		if(parser.getDistance()>0) {
			context.write(new Text("Distance_all"), 
					new LongWritable(parser.getDistance()));
			context.getCounter(DistanceCnt.nonZeroCnt).increment(1);
		}else
			context.getCounter(DistanceCnt.zeroCnt).increment(1);
	}
}













