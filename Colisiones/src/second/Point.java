package second;

public class Point {
	
	private double x, y, angle, speed;
	
	public Point(double x, double y, double angle, double speed) {
		super();
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}	
}
