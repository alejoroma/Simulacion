package first;

public class Simulation {
	
	private Tank tank1;
	private Tank tank2;
	
	//double y1, double y2,double y3, double time, double A
	public Simulation(double y1, double y2,double y3, double time, double A, double y1B, double y2B, double AB) {
		tank1 = new Tank(y1, y2, y3, time, A);
		System.out.println("-------Tanque 2----");
		tank2 = new Tank(y1B, y2B, 0, time, AB);
	}
	
	

}
