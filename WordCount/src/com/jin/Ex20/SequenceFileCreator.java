package com.jin.Ex20;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

public class SequenceFileCreator extends Configured implements Tool {

	static class DistanceMapper extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, Text> {
		private IntWritable outputKey = new IntWritable();

		public void map(LongWritable key, Text value, OutputCollector<IntWritable, Text> output, Reporter reporter)
				throws IOException {
			
			AlReportParser parser = new AlReportParser(value);
			if (parser.isDistanceAvailable()) {
				outputKey.set(parser.getDistance());
				output.collect(outputKey, value);
			}
		}
	}

	public int run(String[] args) throws Exception {
		JobConf conf = new JobConf(SequenceFileCreator.class);
		conf.setJobName("SequenceFileCreator");

		conf.setMapperClass(DistanceMapper.class);
		conf.setNumReduceTasks(0);

		// 입출력 경로 설정
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));

		// 출력 포맷을 SequenceFile로 설정
		conf.setOutputFormat(SequenceFileOutputFormat.class);
		// 출력 키를 항공 운항 거리(IntWritable)로 설정
		conf.setOutputKeyClass(IntWritable.class);

		// 시퀀스 파일 압축 포맷 설정
		SequenceFileOutputFormat.setCompressOutput(conf, true);
		SequenceFileOutputFormat.setOutputCompressorClass(conf, GzipCodec.class);
		SequenceFileOutputFormat.setOutputCompressionType(conf, CompressionType.BLOCK);

		JobClient.runJob(conf);

		return 0;
	}

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new SequenceFileCreator(), args);
		System.out.println("MR-Job Result:" + res);
	}
}

