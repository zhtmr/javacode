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
		
		String[] weekArr= {"월","화","수","목","금","토","일"};		
		week.set(weekArr[idx-1]+"요일");
		
//		switch (idx) {
//		case 1:
//			week.set("월요일");
//			break;
//		case 2:
//			week.set("화요일");
//			break;
//		case 3:
//			week.set("수요일");
//			break;
//		case 4:
//			week.set("목요일");
//			break;
//		case 5:
//			week.set("금요일");
//			break;
//		case 6:
//			week.set("토요일");
//			break;
//		case 7:
//			week.set("일요일");
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
