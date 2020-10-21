package com.jin.Ex08;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
	
	
	
	private IntWritable getTotalCnt(Iterator<IntWritable> values) {
		int cnt =0;
		while(values.hasNext()) {
			cnt += values.next().get();
		}
		return new IntWritable(cnt);
	}
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		
		output.collect(key, getTotalCnt(values));
		

	}

}
