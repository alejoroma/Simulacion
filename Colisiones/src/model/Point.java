package model;

public class Point {
	
	private int x;
	private int y;
	private int speed;
	private int angle;
	public Point(int x, int y, int speed, int angle) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.angle = angle;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
}
