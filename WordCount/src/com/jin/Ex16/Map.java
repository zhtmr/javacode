package com.jin.Ex16;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		AirlineParser parser = new AirlineParser(value);
		
		if(parser.getActualElapsedTime()>AirlineParser.SUSPENSIONOFAIRLINE) {
			Text txt = new Text(parser.getUiqueCarrier()+","+parser.getTailNum()+","+parser.getActualElapsedTime());
			context.write(new Text("Actual:"+parser.getYear()), txt);
			//실 운항이 이루어 지지 않으면 예상 운항은 의미가 없음
			if(parser.getCRSElapsedTime()>AirlineParser.SUSPENSIONOFAIRLINE) {
				txt = new Text(parser.getUiqueCarrier()+","+parser.getTailNum()+","+parser.getCRSElapsedTime());
				context.write(new Text("CRS:"+parser.getYear()), txt);
			}
		}

	}
}













