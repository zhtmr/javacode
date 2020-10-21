package com.jin.Ex08;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	
	/*  
	 * key : 년,월,0 년,월,1 년,월,2
	 *  0 : 1~10    (1~10-1)/10
	 *  1 : 11~20   (11~20-1)/10
	 *  2 : 21~31(28,29,30,31)    (21~31-1)/10
	 *  	* dayOfmonth + 결항정보 배제 22번 cancelled
	 */
	private Text getOutputKey(AirlineParser parser) {
		Text txt = new Text();
		String key = parser.getYear()+","+parser.getMonth()+",";
		int day = (parser.getDayOfmonth()-1)/10;
		if(day==3) day=2;
		txt.set(key+day);
		return txt;
	}
	
	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		AirlineParser parser = new AirlineParser(value);
		if(parser.getCancelled()==AirlineParser.NONCANCELLED)
			output.collect(getOutputKey(parser), new IntWritable(1)); 
		
	}

}
