package com.jin.Ex18;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class GroupkeyPartitioner extends Partitioner<PartSort, IntWritable>{

	@Override
	public int getPartition(PartSort key, IntWritable value, int numPartitions) {
		int hash = String.valueOf(key.getYear()).hashCode();
		// map -> partition
		int partition = hash % numPartitions;
		return partition;
	}
	

}
