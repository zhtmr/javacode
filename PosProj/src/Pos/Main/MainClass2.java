package Pos.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Pos.Menu.DataRepository;
import Pos.Menu.Food;
import Pos.Menu.IMenuManage;
import Pos.Menu.MenuManageImpl;

public class MainClass2 {

	private static void Insert() {
		IMenuManage MenuManage = new MenuManageImpl();
//		 List<Food> foodList = new ArrayList<Food>();
		Map<String, Food> foodMap = new HashMap<String, Food>();
//		 Map<String, Food> foodMap2 = new TreeMap<String, Food>();
		Scanner in = new Scanner(System.in);

		while (true) {
			Food f = (Food) MenuManage.Insert(in);
			String list = (String) MenuManage.Select(f);
			System.out.println(list);
			in.nextLine();
			if ("y".equalsIgnoreCase(in.nextLine()))
				foodMap.put(f.getName(), f);
			System.out.println("계속등록하시겠습니까?(y/n)");
			if ("n".equalsIgnoreCase(in.nextLine())) {
				System.out.println("등록 종료");
				break;
			}
		}
		

		System.out.println(foodMap.size()+"개");
		
		MenuManage = new DataRepository();
		MenuManage.Insert(foodMap);
		
		System.out.println("등록완료");
	}

	public static void main(String[] args) {
		
		Insert();
		
//		Scanner in = new Scanner(System.in);
//		IMenuManage data = new DeleteMenu();
//		data.Select("삭제");
//		data.Select();
//		data.Delete(in);
//		
//		IMenuManage data1 = new ModifyMenu();
//		data1.Select();
//		data1.Modify(in);
		


	}

}
