package com.jin.Ex10;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text>{
	
	
	
	private String getTotalCnt(Iterator<IntWritable> values) {
		int cnt = 0;
		int sum = 0;
		while(values.hasNext()) {
			sum += values.next().get(); 
			cnt++;
		}
		return sum+","+cnt;
	}
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
		
//		String[] split = getTotalCnt(values).split(",");
//		int sum = Integer.parseInt(split[0]);
//		int cnt = Integer.parseInt(split[1]);
		
		output.collect(key, new Text(getTotalCnt(values).split(",")[0]));
		

	}

}
