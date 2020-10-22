package com.jin.Ex16;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce extends Reducer<Text, Text, Text, IntWritable>{
	private MultipleOutputs<Text, IntWritable> multi;
	
	@Override
	protected void setup(Reducer<Text, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multi = new MultipleOutputs<Text, IntWritable>(context);
	}
	private void multiCount(String id, Iterable<Text> values) throws IOException, InterruptedException {
		int max=0;
		String key="";
		
		for(Text value : values) {
			String []keys = value.toString().split(",");
			int data = Integer.parseInt(keys[2]);
			if(max<data) {
				max = data;
				key = keys[0]+"_"+keys[1];
			}
		}
		multi.write(id, key, new IntWritable(max));
	}

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Reducer<Text, Text, Text, IntWritable>.Context ctx) throws IOException, InterruptedException {
		String[] cmd = key.toString().split(":");
		String[] MultipleId = {"Actual", "CRS"};
		if(MultipleId[0].equals(cmd[0]))	multiCount(MultipleId[0], values);
		else if(MultipleId[1].equals(cmd[0]))	multiCount(MultipleId[1], values);
	}
	@Override
	protected void cleanup(Reducer<Text, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multi.close();
	}
}













