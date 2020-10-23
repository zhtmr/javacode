package com.jin.Ex14;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Value extends Configured implements Tool {
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new Value(), args);
		System.exit(exitCode);
	}
	@Override
	public int run(String[] arg0) throws Exception {
		Job job = Job.getInstance(getConf(), "airline count");
		job.setJarByClass(Value.class);
		
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(IntWritable.class);
		
//		job.setMapperClass(Map.class);
//		job.setReducerClass(Reduce.class);
		
		job.setInputFormatClass(TextInputFormat.class);
//		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		job.waitForCompletion(true);
		
		System.out.println("january : "+job.getCounters().findCounter(WeatherDelay.january).getValue());
		System.out.println("february : "+job.getCounters().findCounter(WeatherDelay.february).getValue());
		System.out.println("march : "+job.getCounters().findCounter(WeatherDelay.march).getValue());
		System.out.println("april : "+job.getCounters().findCounter(WeatherDelay.april).getValue());
		System.out.println("may : "+job.getCounters().findCounter(WeatherDelay.may).getValue());
		System.out.println("june : "+job.getCounters().findCounter(WeatherDelay.june).getValue());
		System.out.println("july : "+job.getCounters().findCounter(WeatherDelay.july).getValue());
		System.out.println("august : "+job.getCounters().findCounter(WeatherDelay.august).getValue());
		System.out.println("september : "+job.getCounters().findCounter(WeatherDelay.september).getValue());
		System.out.println("october : "+job.getCounters().findCounter(WeatherDelay.october).getValue());
		System.out.println("november : "+job.getCounters().findCounter(WeatherDelay.november).getValue());
		System.out.println("december : "+job.getCounters().findCounter(WeatherDelay.december).getValue());

		return 0;
	}

}














