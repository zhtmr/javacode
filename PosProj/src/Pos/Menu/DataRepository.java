package Pos.Menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DataRepository implements IMenuManage {

	private String getFood(Food f) {
		return f.getPicture() + "," + f.getName() + "," + f.getContents() + "," + f.getPrice();
	}

	@Override
	public Object Insert(Object... o) {
		File menu = new File("menu.txt");
		Map<String, Food> foodMap = (Map<String, Food>) o[0];

		try {
			// 파일쓰기준비
			BufferedWriter bw = new BufferedWriter(new FileWriter(menu));
			if (menu.isFile() && menu.canWrite()) {
				Set<String> keyset = foodMap.keySet();
				for (String key : keyset) {
					Food f = foodMap.get(key);
					String foodStr = getFood(f);
					bw.write(foodStr);
					bw.newLine();
				}
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일생성완료");

		return null;
	}

	@Override
	public Object Delete(Object... o) {
		
		return null;
	}

	@Override
	public Object Modify(Object... o) {
		
		return null;
	}

	@Override
	public Object Select(Object... o) {
		Map<String, Food> menu = new TreeMap<>();
		int no = 1;
		try {
			FileReader fr = new FileReader("menu.txt");
			BufferedReader br = new BufferedReader(fr);
			String readline;
			while ((readline = br.readLine()) != null) {
				menu.put(String.valueOf(no++), getFood(readline));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return menu;
	}

	private Food getFood(String readLine) {
		Food food = new Food();
		String[] datas = readLine.split(",");
		food.setPicture(datas[0]);
		food.setName(datas[1]);
		food.setContents(datas[2]);
		food.setPrice(Integer.parseInt(datas[3]));
		return food;
	}
}
