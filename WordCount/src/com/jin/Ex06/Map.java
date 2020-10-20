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
		 *  map ���� switch�ؼ� ��~������ reduce�� ������ 
		 *  key������ ��,ȭ,��,��..�� ���޵Ǽ� ��,��,��,�� ������ ���ĵ�
		 *  reduce���� key������ 1,2,3,4..�� �޾Ƽ� ��,ȭ,��..�� �����ؾߵ�
		 *  ��, map���� �����ؼ� �ѱ�� �����Ͱ� �� Ŀ���� �м��� �� �����ɸ�
		 *  map������ �ѱ�⸸�ؾߵȴ�  
		 *  
		 */

//		
		
		// csv ���Ϸ� �����
		
//		output.collect(new Text(String.valueOf(day)+","), new IntWritable(1));
		output.collect(week, new IntWritable(1)); // intwritable, intwritable �� ���༭�� ����
		
		
		
	}

	

}
