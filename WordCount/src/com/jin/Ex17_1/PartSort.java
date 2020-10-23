package com.jin.Ex17_1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

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
//		super.setYear(WritableUtils.readString(in));
		
		// ������ ���� ����
		super.setYear(in.readInt());
		super.setMonth(in.readInt());
	}

	/*
	 *  ��� ���� : year, month ������
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		// ������ ����
//		WritableUtils.writeString(out, super.getYear());
		
		//������ ����
		out.writeInt(super.getYear());
		out.writeInt(super.getMonth());
	}
	
	/*
	 *  �� ���� : compareTo() ���
	 *  	������ 0
	 *  	a > b �̸� ���
	 *  	a < b �̸� ����
	 */
	@Override
	public int compareTo(PartSort data) {
		// ���ڿ� ��
//		int result = super.getYear().compareTo(data.getYear());
		
		// ���ں�
		
		int result = super.getYear() - data.getYear();
		if(result==0)
			result = super.getMonth() - data.getMonth();
		return result;
	}

}
