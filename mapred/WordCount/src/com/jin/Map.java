package com.jin;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/* �Է� : LongWritable, Text
 * ��� : Text, IntWritable
 */
public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	// shuffling ���� ����
	@Override
	public void map(LongWritable key, Text value, // �Է� 
			OutputCollector<Text, IntWritable> output, //���
			Reporter reporter)
			throws IOException {
		/*
		 * StringTokenizer
		 * ���ڿ��� �ܾ�� �и��Ͽ� �迭 �������� ����
		 *  - value�� Hadoop �� Text �����̹Ƿ� value.toString()
		 *  - ��ҹ��ڸ� �����Ƿ� toLowerCase() �� �ҹ��ڷ� �����
		 *  
		 *  ex) value = �ܾ�� ���� �����Ͱ�
		 *  	st = �ܾ��, ����, �����Ͱ�
		 */
		StringTokenizer st = new StringTokenizer(value.toString().toLowerCase(),"'|://|;|:|`| |,|.|}|{|(|)|");
		while(st.hasMoreTokens()) {
			Text outputKey = new Text(st.nextToken());
			IntWritable outputValue = new IntWritable(1);
			output.collect(outputKey, outputValue);
		}
		
	}

}
