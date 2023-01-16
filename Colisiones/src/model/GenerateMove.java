package model;

import java.util.Iterator;

public class GenerateMove extends Thread{
	
	private int time;
	private Point point;
	private String name;
	
	public GenerateMove(Point point, int time, String name) {
		this.time = time;
		this.point = point;
		this.name = name;
		
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < time; i++) {
				if (point.getAngle() == 0) {
					point.setX(point.getX() + point.getSpeed());
				}
				if (point.getAngle() == 90) {
					point.setY(point.getY() - point.getSpeed());
				}
				if (point.getAngle() == 180) {
					point.setX(point.getX() - point.getSpeed());
				}
				if (point.getAngle() == 270) {
					point.setY(point.getY() + point.getSpeed());
				}
				System.out.println("la posision de" + name +   point.getX() + ", " + point.getY());
				sleep(1000);
			}
			
		} catch (Exception e) {
		}
		super.run();
	}
	

}
