package com.jin.Ex18;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

// WritableComparator 상속 : 사용자 정의 compare 하겠다
public class SortComparator extends WritableComparator{
	public SortComparator() {
		// 이부분 읽을때 super의 기본생성자를 읽기때문에 미리 기본생성자 만들어놔야된다. PartSort(){}, AirlineParser(){}
		super(PartSort.class, true);
	}
	
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		PartSort data1 = (PartSort) obj1;
		PartSort data2 = (PartSort) obj2;
		
		return data1.compareTo(data2);
	}

}
