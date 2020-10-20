package com.jin.Ex07;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	private Text getOutputKey(AirlineParser parser) {
		String month = String.format("%02d", parser.getMonth());
		return new Text(parser.getYear()+"³â"+month+"¿ù");
	}
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		AirlineParser parser = new AirlineParser(value);
		if(parser.getDeptime()==AirlineParser.SUSPENSIONOFAIRLINE) {
			
			output.collect(getOutputKey(parser), new IntWritable(1)); 
		}
		
	}

}
