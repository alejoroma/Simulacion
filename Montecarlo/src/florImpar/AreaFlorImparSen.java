package florImpar;

public class AreaFlorImparSen {
	
	private int shots;
	
	public AreaFlorImparSen(int shots) {
		this.shots = shots;
	}
	
	public double calculateArea() {
		int aciertos = 0;
		for (int i = 0; i < shots; i++) {
			double randomAngle=  (Math.random() * 90);
			System.out.println("angle= " + randomAngle );
			if (randomAngle >=15 && randomAngle<= 45) {
				double radians = toRadians(randomAngle);
				double r = 2 *Math.sin(3 *radians);
				System.out.println("r= " + r );
				if (r <= 2){
					aciertos ++;
				}
			}
		}
		return (double) aciertos/shots;
	}
	
	public double calculateArea3() {
		return 3 * calculateArea();
	}
	
	private double toRadians(double angle) {
		return angle/180;
	}
}