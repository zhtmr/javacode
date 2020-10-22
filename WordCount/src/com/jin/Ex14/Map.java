package com.jin.Ex14;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Counter;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
	private void MonthlyWeatherDelay(Context ctx, AirlineParser ap) {
		Counter counter=null;
		switch(ap.getMonth()) {
		case 1:counter=ctx.getCounter(WeatherDelay.january);break;
		case 2:counter=ctx.getCounter(WeatherDelay.february);break;
		case 3:counter=ctx.getCounter(WeatherDelay.march);break;
		case 4:counter=ctx.getCounter(WeatherDelay.april);break;
		case 5:counter=ctx.getCounter(WeatherDelay.may);break;
		case 6:counter=ctx.getCounter(WeatherDelay.june);break;
		case 7:counter=ctx.getCounter(WeatherDelay.july);break;
		case 8:counter=ctx.getCounter(WeatherDelay.august);break;
		case 9:counter=ctx.getCounter(WeatherDelay.september);break;
		case 10:counter=ctx.getCounter(WeatherDelay.october);break;
		case 11:counter=ctx.getCounter(WeatherDelay.november);break;
		case 12:counter=ctx.getCounter(WeatherDelay.december);break;
		}
		counter.increment(ap.getWeatherDelay());
	}
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		AirlineParser parser = new AirlineParser(value);
		if(parser.getWeatherDelay()>0) {
			MonthlyWeatherDelay(context, parser);
		}
	}
}













