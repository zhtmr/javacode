package com.jin.Ex15;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	private MultipleOutputs<Text, IntWritable> multi;
	/*
	 *  Mapper 클래스와 Reducer 클래스는 각각의 태스크가 수행될 때 
	 *  오버라이드한 map, 또는 reduce 함수 뿐만 아니라 태스크의 시작 전, 후의 처리를 할 수 있다. 
	 *  setup 함수는 태스크의 시작 전에 한번 수행되고 cleanup은 해당 태스크가 끝나면 한번 수행된다.
	 */
	
	/*
	 *  전처리 : output을 조건에 따라 여러개로 출력 
	 *  context.write() 대신 MultipleOutputs.write()
	 */
	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// MultipleOutputs에 context 전달
		multi = new MultipleOutputs<Text, IntWritable>(context);
	}
	
	private void multiCount(String id, String key, Iterable<IntWritable> values) throws IOException, InterruptedException {
		int cnt = 0;
		
		for(IntWritable v : values)
			cnt += v.get();
		/*
		 *  /output/arr-r-00000
		 *  /output/dep-r-00000
		 */
		multi.write(id, key, new IntWritable(cnt)); // "arr"/"dep", cmd[1], cnt
	}
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context ctx) throws IOException, InterruptedException {
		String [] cmd = key.toString().split(":"); // cmd[0] : dep or arr | cmd[1] : 항공사
		if("dep".contentEquals(cmd[0]))
			multiCount("dep", cmd[1], values);
		else if("arr".contentEquals(cmd[0]))
			multiCount("arr", cmd[1], values);
	}
	
	// 후처리
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multi.close();
	}
}













