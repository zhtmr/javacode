package com.jin.Ex06;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce extends MapReduceBase implements Reducer<IntWritable, IntWritable, Text, IntWritable>{
	
	private Text getWeek(int idx) {
		Text week = new Text();
		
		String[] weekArr= {"��","ȭ","��","��","��","��","��"};		
		week.set(weekArr[idx-1]+"����");
		
//		switch (idx) {
//		case 1:
//			week.set("������");
//			break;
//		case 2:
//			week.set("ȭ����");
//			break;
//		case 3:
//			week.set("������");
//			break;
//		case 4:
//			week.set("�����");
//			break;
//		case 5:
//			week.set("�ݿ���");
//			break;
//		case 6:
//			week.set("�����");
//			break;
//		case 7:
//			week.set("�Ͽ���");
//			break;
//		}
		return week;
	}
	
	private IntWritable getTotalCnt(Iterator<IntWritable> values) {
		int cnt =0;
		while(values.hasNext()) {		
			cnt += values.next().get();
		}
		return new IntWritable(cnt);
	}
	
	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		
		output.collect(getWeek(key.get()), getTotalCnt(values));
		

	}

}
