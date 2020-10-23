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
		// 하둡에서 실행할 파일 설정. 인자로 main class를 전달
		JobConf conf = new JobConf(WordCount.class);
		// title 설정
		conf.setJobName("wordcount");
		// 출력 형식 지정. reduce 에서 전달되는 key, value 자료형
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		// Mapper 연결
		conf.setMapperClass(Map.class);
		// Reducer 연결
		conf.setReducerClass(Reduce.class);
		// 입출력 클래스 지정
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		// 하둡에서 입출력 경로 설정
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		// 설정 내용 적용
		JobClient.runJob(conf);
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int exitcode = ToolRunner.run(new WordCount(), args);
		System.exit(exitcode);
		
	}

}
