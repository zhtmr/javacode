package com.jin.Ex17;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
	
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		int cnt =0;
		while(value.hasNext()) {		
			cnt += value.next().get();
			
		}
		
//		AirlineParser parser = new AirlineParser(key);
//		int month = parser.getMonth();
		
		output.collect(key, new IntWritable(cnt));
		

	}

}
