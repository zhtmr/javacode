package com.jin.Ex17_1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, PartSort, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, PartSort, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
//		AirlineParser parser = new AirlineParser(value);
		
		
		// ������ PartSort���� ������ ��Ĵ�� �ϰڴ�
		PartSort parser = new PartSort(value);
		if(!parser.isCancelled()) {
			context.write(parser, new IntWritable(1));
		}
	}

}













