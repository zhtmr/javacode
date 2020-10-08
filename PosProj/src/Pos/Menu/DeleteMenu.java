package Pos.Menu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DeleteMenu implements IMenuManage {

	private String getMenu(Map<String, Food> menuMap) {
		String menuStr = "";

		for (Entry<String, Food> entry : menuMap.entrySet()) {
			menuStr += entry.getKey() + ". ";
			Food food = entry.getValue();
			menuStr += food.getName() + "\n";
		}
		return menuStr;
	}

//	// menu 잘라서 1번째
//	private String getMenu(String menu) {
//		return menu.split(",")[1];
//	}

	@Override
	public Object Insert(Object... o) {
		return null;
	}

	@Override
	public Object Delete(Object... o) {
		Scanner in = (Scanner) o[0];
		String no = in.next();

		IMenuManage iMenu = new DataRepository();
		Map<String, Food> menuMap = (Map<String, Food>) iMenu.Select();

		System.out.println(menuMap.get(no).getName() + "를 삭제하시겠습니까?(y/n)");

		String yn = in.next();
		if ("y".equalsIgnoreCase(yn)) {
			menuMap.remove(no);
			iMenu.Insert(menuMap);

		}
		return null;
	}

	@Override
	public Object Modify(Object... o) {
		return null;
	}

	@Override
	public Object Select(Object... o) {
		IMenuManage iMenu = new DataRepository();
		Map<String, Food> menuMap = (Map<String, Food>) iMenu.Select();
		System.out.println("메뉴 삭제");
		System.out.println("=======================");
		System.out.println(getMenu(menuMap));
		System.out.println("=======================");
		System.out.println("삭제할 메뉴를 고르세요");

		return null;
	}

}
