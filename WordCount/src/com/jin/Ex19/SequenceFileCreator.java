package com.jin.Ex19;

import java.io.IOException;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class SequenceFileCreator extends Configured implements Tool {
	
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new SequenceFileCreator(), args);
		System.exit(exitCode);
	}
	
	// 탐색하기 위해 시퀀스파일 만드는과정
	static class SequenceMapper extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, Text>{

		private IntWritable outputKey = new IntWritable();
		
		@Override
		public void map(LongWritable key, Text value, OutputCollector<IntWritable, Text> output, Reporter arg3)
				throws IOException {
			AirlineParser parser = new AirlineParser();
			if(parser.isDistanceAvailable()) {
				outputKey.set(parser.getDistance());
				output.collect(outputKey, value);
			}
		}
		
	}
	@Override
	public int run(String[] arg0) throws Exception {
		JobConf conf = new JobConf(SequenceFileCreator.class);
		conf.setJobName("SequenceFileCreator");
		
		conf.setMapperClass(SequenceMapper.class);
		conf.setNumReduceTasks(0);
		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		// 출력 형식을 SequenceFile 로 지정
		conf.setOutputFormat(SequenceFileOutputFormat.class);
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














