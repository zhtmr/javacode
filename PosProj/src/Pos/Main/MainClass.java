//package Pos.Main;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Set;
//
//import Pos.Menu.DataRepository;
//import Pos.Menu.Food;
//import Pos.Menu.IMenuManage;
//import Pos.Menu.MenuManageImpl;
//
//public class MainClass {
//
//	private static Object Insert() {
//		IMenuManage MenuManage = new MenuManageImpl();
////		 List<Food> foodList = new ArrayList<Food>();
//		Map<String, Food> foodMap = new HashMap<String, Food>();
////		 Map<String, Food> foodMap2 = new TreeMap<String, Food>();
//		Scanner in = new Scanner(System.in);
//
//		while (true) {
//			Food f = (Food) MenuManage.Insert(in);
//			String list = (String) MenuManage.Select(f);
//			System.out.println(list);
//			in.nextLine();
//			if ("y".equalsIgnoreCase(in.nextLine()))
//				foodMap.put(f.getName(), f);
//			System.out.println("계속등록하시겠습니까?(y/n)");
//			if ("n".equalsIgnoreCase(in.nextLine())) {
//				System.out.println("등록 종료");
//				break;
//			}
//		}
//
//		System.out.println(foodMap.size()+"개");
//		
//		MenuManage = new DataRepository();
//		
//		System.out.println("등록완료");
//		return MenuManage.Insert(foodMap);
//	}
//
//	public static void main(String[] args) {
//		Map<String, Food> foodMap = (Map<String, Food>) Insert();
//		Set<String> keyset = foodMap.keySet();
//		
//		
//		// 파일 생성
//		File menu = new File("menu.txt");
//
//		try {
//			// 파일쓰기준비
//			BufferedWriter bw = new BufferedWriter(new FileWriter(menu));
//			if (menu.isFile() && menu.canWrite())
//				for(String key : keyset) {
//					Food food = foodMap.get(key);
//					bw.write(food.getPicture()+" , "+food.getName()+" , "+food.getContents()+" , "+food.getPrice());
//					bw.newLine();
//				}
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("파일생성완료");
//
//	}
//
//}
