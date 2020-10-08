package Pos.Menu;

import java.awt.FileDialog;
import java.util.Scanner;

import javax.swing.JFrame;

public class MenuManageImpl implements IMenuManage{
	
	final String FILEOPENTITLE = "파일열기";
	final String FILEPATH = "c:";
	
	public String picture() {
		JFrame frame = null;
		FileDialog fileDialog = new FileDialog(frame,FILEOPENTITLE,0);
		fileDialog.setDirectory(FILEPATH);
		fileDialog.setVisible(true);
		return fileDialog.getFile()+" ["+ fileDialog.getDirectory()+"]";
	}
	
	
	@Override
	public Object Insert(Object...o) {
		System.out.println("메뉴 등록");
		System.out.println("=======================================");
		System.out.println("사진을 등록하시겠습니까?(y/n)");
		
		Food f = new Food();
		
		Scanner in = (Scanner) o[0];
		String value = in.nextLine();
						
		if ("y".equalsIgnoreCase(value)) { // value.equalsIgnoreCase("y") 이렇게 쓰면 value = null위험
			String picPath = picture();
			f.setPicture(picPath);
		}else
			f.setPicture("없음");
		 
		System.out.println("이름을 등록하세요?");
		f.setName(in.nextLine());
		System.out.println("설명을 등록하세요?");
		f.setContents(in.nextLine());
		System.out.println("가격을 등록하세요?");
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
		String ret = "현재 등록한 정보는 \n";
		ret += "사진 : "+f.getPicture()+"\n";
		ret += "이름 : "+f.getName()+"\n";
		ret += "설명 : "+f.getContents()+"\n";
		ret += "가격 : "+f.getPrice()+"\n";
		ret += "맞습니까?(y/n) \n";
		
		return ret;
		
	}

}
