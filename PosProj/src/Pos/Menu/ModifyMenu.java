package Pos.Menu;

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
		
		return null;
	}

	@Override
	public Object Select(Object... o) {
		super.Select("����");
		return null;
	}

}
