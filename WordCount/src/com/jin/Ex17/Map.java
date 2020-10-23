package com.jin.Ex17;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		AirlineParser parser = new AirlineParser(value);
		int yearInt = parser.getYear();
		int monthInt = parser.getMonth();
//		String month = String.format("%02d", parser.getMonth());
		
		// csv 파일로 만들기
//		String yearmonth = String.valueOf(yearInt)+","+String.valueOf(monthInt)+",";
		String yearmonth = yearInt+"."+monthInt;
		
		output.collect(new Text(yearmonth), new IntWritable(1));
		
	}

	

}
