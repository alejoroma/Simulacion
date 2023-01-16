package flor2Pi;

public class AreaFlorParSen {
	
	private int shots;
	
	public AreaFlorParSen(int shots) {
		this.shots = shots;
	}
	
	public double calculateArea() {
		int aciertos = 0;
		for (int i = 0; i < shots; i++) {
			double randomAngle=  (Math.random() * 90);
			if (randomAngle >=30 && randomAngle<= 60) {
				double radians = toRadians(randomAngle);
				double r = Math.sin(2 *radians);
				if (r <= 1){
					aciertos ++;
				}
			}
		}
		return (double) aciertos/shots;
	}
	
	public double calculateArea4() {
		return 4 * calculateArea();
	}
	
	private double toRadians(double angle) {
		return angle/180;
	}
}