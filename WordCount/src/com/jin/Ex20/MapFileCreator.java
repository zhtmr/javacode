package com.jin.Ex20;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MapFileCreator extends Configured implements Tool {

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new MapFileCreator(), args);
		System.out.println("MR-Job Result:" + res);
	}

	public int run(String[] args) throws Exception {
		JobConf conf = new JobConf(MapFileCreator.class);
		conf.setJobName("MapFileCreator");

		// ����� ��� ����
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));

		// �Է� �����͸� SequenceFile�� ����
		conf.setInputFormat(SequenceFileInputFormat.class);
		// ��� �����͸� MapFile�� ����
		conf.setOutputFormat(MapFileOutputFormat.class);
		// ��� �������� Ű�� �װ� ���� �Ÿ�(IntWrtiable)�� ����
		conf.setOutputKeyClass(IntWritable.class);

		// ������ ���� ���� ���� ����
//		SequenceFileOutputFormat.setCompressOutput(conf, true);
//		SequenceFileOutputFormat.setOutputCompressorClass(conf, GzipCodec.class);
//		SequenceFileOutputFormat.setOutputCompressionType(conf, CompressionType.BLOCK);

		JobClient.runJob(conf);

		return 0;
	}

}
