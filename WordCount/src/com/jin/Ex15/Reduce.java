package com.jin.Ex15;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	private MultipleOutputs<Text, IntWritable> multi;
	/*
	 *  Mapper Ŭ������ Reducer Ŭ������ ������ �½�ũ�� ����� �� 
	 *  �������̵��� map, �Ǵ� reduce �Լ� �Ӹ� �ƴ϶� �½�ũ�� ���� ��, ���� ó���� �� �� �ִ�. 
	 *  setup �Լ��� �½�ũ�� ���� ���� �ѹ� ����ǰ� cleanup�� �ش� �½�ũ�� ������ �ѹ� ����ȴ�.
	 */
	
	/*
	 *  ��ó�� : output�� ���ǿ� ���� �������� ��� -> MultipleOutputs
	 */
	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multi = new MultipleOutputs<Text, IntWritable>(context);
	}
	
	private void multiCount(String id, String key, Iterable<IntWritable> values) throws IOException, InterruptedException {
		int cnt = 0;
		
		for(IntWritable v : values)
			cnt += v.get();
		
		multi.write(id, key, new IntWritable(cnt));
	}
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context ctx) throws IOException, InterruptedException {
		String [] cmd = key.toString().split(":"); // cmd[0] : dep or arr | cmd[1] : �װ���
		if("dep".contentEquals(cmd[0]))
			multiCount("dep", cmd[1], values);
		else if("arr".contentEquals(cmd[0]))
			multiCount("arr", cmd[1], values);
	}
	
	// ��ó��
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multi.close();
	}
}













