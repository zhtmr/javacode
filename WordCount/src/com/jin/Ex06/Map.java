package com.jin.Ex06;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, IntWritable>{

	
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<IntWritable, IntWritable> output, Reporter reporter)
			throws IOException {

		AirlineParser parser = new AirlineParser(value);
		IntWritable week = new IntWritable(parser.getDay());
//		int day = parser.getDay();
		/*
		 *  map 에서 switch해서 월~금으로 reduce로 보내면 
		 *  key값으로 월,화,수,목..이 전달되서 ㄱ,ㄴ,ㄷ,ㄹ 순으로 정렬됨
		 *  reduce에서 key값으로 1,2,3,4..를 받아서 월,화,수..로 매핑해야됨
		 *  또, map에서 가공해서 넘기면 데이터가 더 커져서 분석에 더 오래걸림
		 *  map에서는 넘기기만해야된다  
		 *  
		 */

//		
		
		// csv 파일로 만들기
		
//		output.collect(new Text(String.valueOf(day)+","), new IntWritable(1));
		output.collect(week, new IntWritable(1)); // intwritable, intwritable 로 리듀서에 전달
		
		
		
	}

	

}
