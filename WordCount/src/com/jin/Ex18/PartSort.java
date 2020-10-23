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
	 *  ����ȭ�� ������ �����ϴ� �κ� : year, month �� int �������� �ְڴ�
	 *  ���� �ʿ��� �����Ϳ� ���� �ִ´�
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		// ���ڿ� ���� ����
		super.setUiqueCarrier(WritableUtils.readString(in));
		super.setTailNum(WritableUtils.readString(in));
		
		// ������ ���� ����
//		super.set
//		super.setMonth(in.readInt());
	}

	/*
	 *  ��� ���� : year, month ������
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		// ������ ����
		WritableUtils.writeString(out, super.getUiqueCarrier());
		WritableUtils.writeString(out, super.getTailNum());
		
		//������ ����
//		out.writeInt(super.getYear());
//		out.writeInt(super.getMonth());
	}
	
	/*
	 *  �� ���� : java a.compareTo(b) ���
	 *  	������ 0
	 *  	a > b �̸� ���
	 *  	a < b �̸� ����
	 */
	@Override
	public int compareTo(PartSort data) {
		// ���ڿ� ��
		
		int result = super.getUiqueCarrier().compareTo(data.getUiqueCarrier());
		if(result==0)
			result =super.getTailNum().compareTo(data.getTailNum())*-1; // �������� *(-1) = ��������
		
		// ���ں�
		
//		int result = super.getYear() - data.getYear();
//		if(result==0)
//			result = super.getMonth() - data.getMonth();
		return result;
	}

}
