package com.jin.Ex18;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class PartSort extends AirlineParser implements WritableComparable<PartSort>{

	public PartSort() {}
	public PartSort(Text txt) {
		super(txt);
	}
	
	/*
	 *  직렬화로 데이터 전달하는 부분 : year, month 에 int 형식으로 넣겠다
	 *  지금 필요한 데이터에 값을 넣는다
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		// 문자열 전달 형식
		super.setUiqueCarrier(WritableUtils.readString(in));
		super.setTailNum(WritableUtils.readString(in));
		
		// 정수형 전달 형식
//		super.set
//		super.setMonth(in.readInt());
	}

	/*
	 *  출력 형식 : year, month 가져옴
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		// 문자형 전달
		WritableUtils.writeString(out, super.getUiqueCarrier());
		WritableUtils.writeString(out, super.getTailNum());
		
		//숫자형 전달
//		out.writeInt(super.getYear());
//		out.writeInt(super.getMonth());
	}
	
	/*
	 *  비교 형식 : java a.compareTo(b) 사용
	 *  	같으면 0
	 *  	a > b 이면 양수
	 *  	a < b 이면 음수
	 */
	@Override
	public int compareTo(PartSort data) {
		// 문자열 비교
		
		int result = super.getUiqueCarrier().compareTo(data.getUiqueCarrier());
		if(result==0)
			result =super.getTailNum().compareTo(data.getTailNum())*-1; // 오름차순 *(-1) = 내림차순
		
		// 숫자비교
		
//		int result = super.getYear() - data.getYear();
//		if(result==0)
//			result = super.getMonth() - data.getMonth();
		return result;
	}

}
