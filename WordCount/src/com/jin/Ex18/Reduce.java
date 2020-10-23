package com.jin.Ex18;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<PartSort, IntWritable, Text, FloatWritable>{
	
	
	@Override
	protected void reduce(PartSort key, Iterable<IntWritable> values,
			Reducer<PartSort, IntWritable, Text, FloatWritable>.Context ctx) throws IOException, InterruptedException {
		int cnt=0, totalCnt=0;
		
		for(IntWritable v : values) {
			totalCnt++;
			if(v.get()>AirlineParser.NONAIRFLIGHT)
				cnt++;
		}
		if(cnt*totalCnt!=0) // if(cnt!=0 && totalCnt!=0)
			ctx.write(new Text(key.getUiqueCarrier()+"_"+key.getTailNum()), new FloatWritable((float)cnt/(float)totalCnt));
	}
	
}













