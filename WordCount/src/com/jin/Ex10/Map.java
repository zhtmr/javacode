package com.jin.Ex10;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	// 항공기 낙후도 : 11,22,23,24,25번 사용
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		AirlineParser parser = new AirlineParser(value);
		/*
		 *  key : tailNum
		 *  value : 다음 조건에 맞는 카운트
		 *  	1. 항공사 사정으로 취소
		 *  	2. 항공사 사정으로 지연
		 *  	3. 우회
		 */
		if(parser.isCancelled() && "a".equalsIgnoreCase(parser.getCancellationCode()) 
				|| parser.getCarrierDelay()>AirlineParser.NONAIRFLIGHT 
				|| parser.isDiverted())
			output.collect(new Text(parser.getTailNum()), new IntWritable(1)); 
		
	}

}
