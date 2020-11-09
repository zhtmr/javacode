package com.jin;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class TestLogMain {
	public static Logger logger = LogManager.getLogger("Log Text");
	public static void main(String[] args) {
		System.setProperty("logFilename", "./LogDir/log.csv");
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		ctx.reconfigure();
		
		Random rand = new Random();
		// ���� ����
		// rand.nextInt(����)+���۰�
//		for(int i=0; i<10; i++)
//			System.out.println(rand.nextInt(10)+10);
		
		// ����ġ�� �̿��� ���� ����
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		map.put(10, 50D);
		map.put(13, 30D);
		map.put(17, 15D);
		map.put(19, 5D);
		
		for(int i=0;i<10;i++)
			System.out.println(getWeightedRandom(map, rand));
		// ���� ����
		String [] day= {"��","ȭ","��","��","��","��","��"};
		for(int i=0;i<7;i++) {
//			System.out.println(rand.nextInt(7));
			System.out.println(day[rand.nextInt(7)]);
			
//			int dayIdx=rand.nextInt(7);
//			System.out.println(day[dayIdx]);
		}
//		logger.info("hello,world");
//		System.out.println("log");
		
		for(int i=0;i<20;i++) {
			logger.info(getWeightedRandom(map, rand)+","+day[rand.nextInt(7)]+"����");
		}

		// ���� ����ġ
		Map<String, Double> map2 = new HashMap<String, Double>();
		map2.put(day[0], 50D); // "��"
		map2.put("ȭ", 30D);
		map2.put("��", 15D);
		map2.put(day[6], 5D); // "��"

		for(int i=0;i<7;i++)
			System.out.println(getWeightedRandom(map2, rand));
		
	}
	
	// ����ġ �˰���
	public static <E> E getWeightedRandom(Map<E, Double> weights, Random random) { 
		E result = null;  
		double bestValue = Double.MAX_VALUE;    
		for (E element : weights.keySet()) {     
			double value = -Math.log(random.nextDouble()) / weights.get(element);     
			if (value < bestValue) {      
				bestValue = value;       result = element; 
			}  
		}   return result; 
	}
}
