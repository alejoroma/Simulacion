package model;

public class Simulation {
	
	private Point point1 = new Point(3, 3, 5, 270);
	private Point point2 = new Point(3, 13, 5, 0);
	private Point point3 = new Point(50, 13, 8, 180);
	private GenerateMove firstMove, secMove, trhMove;
	
	
	public Simulation(int Time) {
		firstMove= new GenerateMove(point1, Time, " 1 ");
		firstMove.start();
		
		secMove= new GenerateMove(point2, Time, " 2 ");
		secMove.start();
		
		trhMove= new GenerateMove(point3, Time," 3 ");
		trhMove.start();
	}
}
//x cos