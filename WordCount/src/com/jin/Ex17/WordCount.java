package com.jin.Ex17;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCount extends Configured implements Tool{


	@Override
	public int run(String[] arg0) throws Exception {
		// �ϵӿ��� ������ ���� ����. ���ڷ� main class�� ����
		JobConf conf = new JobConf(WordCount.class);
		// title ����
		conf.setJobName("wordcount");
		// ��� ���� ����. reduce ���� ���޵Ǵ� key, value �ڷ���
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		// Mapper ����
		conf.setMapperClass(Map.class);
		// Reducer ����
		conf.setReducerClass(Reduce.class);
		// ����� Ŭ���� ����
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		// �ϵӿ��� ����� ��� ����
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		// ���� ���� ����
		JobClient.runJob(conf);
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int exitcode = ToolRunner.run(new WordCount(), args);
		System.exit(exitcode);
		
	}

}
