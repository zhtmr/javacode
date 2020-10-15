package com.jin.Ex01;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;

public class KeyValueMain extends Configured implements Tool{
	
	
	public static void main(String[] args) {
	
	}

	@Override
	public int run(String[] arg0) throws Exception {
		JobConf conf = new JobConf(KeyValueMain.class);
		
		conf.setJobName("Map K1 V1 Test");
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		
		conf.setMapperClass(TestMap.class);
		conf.setReducerClass(TestReducer.class);
		
		
		return 0;
	}
}
