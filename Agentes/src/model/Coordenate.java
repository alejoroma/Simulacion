package model;

public class Coordenate {
	protected double x; 
	protected double y;
	
	public Coordenate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(double distance, double angle) {
		this.x = this.x + (distance * Math.cos(angle));
		this.y = this.y + (distance * Math.sin(angle));
	}
}
