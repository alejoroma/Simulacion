package hourRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class HourRandom {
	private Random random = new Random() ;
	private int average = 10;
	private int count = 0;

	public HourRandom() {

		for (int initTime = 0; initTime < 3600; initTime += random.nextInt(2*average)) {
//			System.out.println(initTime);
			if (random.nextDouble()<= (double)1/average) {
				System.out.println(toHour(initTime) );
			}else {
//				System.out.println(toHour(initTime) + " no");
			}
			
			
			count++;
		}
//		System.out.println("Promedio " +  (double)3600/count);
	}

	private String toHour(int time) {
		int num = time;
		int seconds = num % 60;
		int hour = 0;
		num -= seconds;
		int  minute =0;
		if(num > 0) {
			num /= 60;
			  minute = num % 60;
			num -= minute;
			if(num > 0) {
				 hour = num / 60;
			}          
		}
//		System.out.println(""+ hour+ ":" + minute +":"+ seconds);
		return ""+ hour+ ":" + minute +":"+ seconds;
	}
	
	private ArrayList<Integer> aleatoryEvent(int prom){
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3600/prom; i++) {
			double num = random.nextDouble();
			if(num < 0.5) {
				list.add(0);
			}else {
				list.add(1);
			}
			
		}
		return list;
	}
	
	public void printList(int prom) {
		ArrayList<Integer> myList  = aleatoryEvent(prom);
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
	}
	
	
}