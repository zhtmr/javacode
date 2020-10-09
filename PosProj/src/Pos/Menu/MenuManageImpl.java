package Pos.Menu;

import java.awt.FileDialog;
import java.util.Scanner;

import javax.swing.JFrame;

public class MenuManageImpl implements IMenuManage{
	
	final String FILEOPENTITLE = "���Ͽ���";
	final String FILEPATH = "c:";
	
	public String picture() {
		JFrame frame = null;
		FileDialog fileDialog = new FileDialog(frame,FILEOPENTITLE,0);
		fileDialog.setDirectory(FILEPATH);
		fileDialog.setVisible(true);
		return fileDialog.getFile()+" ["+ fileDialog.getDirectory()+"]";
	}
	
	// TODO: Scanner �� �������� �ʰ� ��簴ü �Ǻ��ϰ� 
	public Scanner parameter(Object... o) {
		Scanner in=null;
		for(int i =0; i<o.length; i++) {
			if(o[i] instanceof Scanner) {
				in = (Scanner) o[i];
				break;
			}
		}
		return in;
	}
	
	@Override
	public Object Insert(Object...o) {
		System.out.println("�޴� ���");
		System.out.println("=======================================");
		System.out.println("������ ����Ͻðڽ��ϱ�?(y/n)");
		
		Food f = new Food();
		
		// �� �κ��� �޼ҵ�� ���� �����Ѱ�? : o�� ���� ��ü �Ǵ��ϴ� �޼ҵ�?
		Scanner in = parameter(o);
		
		
		String value = in.nextLine();
						
		if ("y".equalsIgnoreCase(value)) { // value.equalsIgnoreCase("y") �̷��� ���� value = null����
			String picPath = picture();
			f.setPicture(picPath);
		}else
			f.setPicture("����");
		 
		System.out.println("�̸��� ����ϼ���?");
		f.setName(in.nextLine());
		System.out.println("������ ����ϼ���?");
		f.setContents(in.nextLine());
		System.out.println("������ ����ϼ���?");
		f.setPrice(in.nextInt());
		
		
		return f;
		
	}

	@Override
	public Object Delete(Object...o) {
		return o;
		
		
	}

	@Override
	public Object Modify(Object...o) {
		return o;
		
		
	}

	@Override
	public Object Select(Object...o) { // o[0], o[1], o[2] ....
		Food f=(Food) o[0];
		String ret = "���� ����� ������ \n";
		ret += "���� : "+f.getPicture()+"\n";
		ret += "�̸� : "+f.getName()+"\n";
		ret += "���� : "+f.getContents()+"\n";
		ret += "���� : "+f.getPrice()+"\n";
		ret += "�½��ϱ�?(y/n) \n";
		
		return ret;
		
	}

}
