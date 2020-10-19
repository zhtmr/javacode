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

/* 입력 : LongWritable, Text
 * 출력 : Text, IntWritable
 */
public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{

	// shuffling 으로 전달
	@Override
	public void map(LongWritable key, Text value, // 입력 
			OutputCollector<Text, IntWritable> output, //출력
			Reporter reporter)
			throws IOException {
		/*
		 * StringTokenizer
		 * 문자열을 단어별로 분리하여 배열 형식으로 저장
		 *  - value는 Hadoop 의 Text 형식이므로 value.toString()
		 *  - 대소문자를 따지므로 toLowerCase() 로 소문자로 만든다
		 *  
		 *  ex) value = 단어별로 나눈 데이터가
		 *  	st = 단어별로, 나눈, 데이터가
		 */
		StringTokenizer st = new StringTokenizer(value.toString().toLowerCase(),"'|://|;|:|`| |,|.|}|{|(|)|");
		while(st.hasMoreTokens()) {
			Text outputKey = new Text(st.nextToken());
			IntWritable outputValue = new IntWritable(1);
			output.collect(outputKey, outputValue);
		}
		
	}

}
