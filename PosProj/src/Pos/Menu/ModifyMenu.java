package Pos.Menu;

import java.util.Map;
import java.util.Scanner;

public class ModifyMenu extends DeleteMenu implements IMenuManage{

	
	@Override
	public Object Insert(Object... o) {
		
		return null;
	}

	@Override
	public Object Delete(Object... o) {
		
		return null;
	}

	@Override
	public Object Modify(Object... o) {
		Scanner in = (Scanner) o[0];
		String n = in.next();
		
		IMenuManage iMenu = new DataRepository();
		Map<String, Food> menuMap = (Map<String, Food>) iMenu.Select();
		String selected = menuMap.get(n).getName();
		System.out.println("���õ� �� : "+selected);
		System.out.print("������ ���� �Է�");
		String modify = in.next();
		menuMap.get(n).setName(modify);
		iMenu.Insert(menuMap);
		System.out.println("�����Ϸ�");
		return null;
	}

	@Override
	public Object Select(Object... o) {
		super.Select("����");
		return null;
	}

}