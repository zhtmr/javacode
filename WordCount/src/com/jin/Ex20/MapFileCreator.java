package com.jin.Ex20;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapFileOutputFormat;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MapFileCreator extends Configured implements Tool {
	
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new MapFileCreator(), args);
		System.exit(exitCode);
	}
	
	
	@Override
	public int run(String[] arg0) throws Exception {
		JobConf conf = new JobConf(MapFileCreator.class);
		conf.setJobName("SequenceFileCreator");
		
//		conf.setMapperClass(SequenceMapper.class);
//		conf.setNumReduceTasks(0);
		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		// 입력 형식을 SequenceFile 로 지정
		conf.setInputFormat(SequenceFileInputFormat.class);
		// 출력 형식을 MapFile 로 지정
		conf.setOutputFormat(MapFileOutputFormat.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(Text.class);
		
		// 시퀀스 파일 압축 설정
		SequenceFileOutputFormat.setCompressOutput(conf, true);
		SequenceFileOutputFormat.setOutputCompressorClass(conf, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(conf, CompressionType.BLOCK);
		
		JobClient.runJob(conf);
		return 0;
	}

}














