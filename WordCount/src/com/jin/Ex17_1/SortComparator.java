package com.jin.Ex17_1;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SortComparator extends WritableComparator{
	public SortComparator() {
		// �̺κ� ������ super�� �⺻�����ڸ� �б⶧���� �̸� �⺻������ �������ߵȴ�. PartSort(){}, AirlineParser(){}
		super(PartSort.class, true);
	}
	
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		PartSort data1 = (PartSort) obj1;
		PartSort data2 = (PartSort) obj2;
		
		return data1.compareTo(data2);
	}

}
