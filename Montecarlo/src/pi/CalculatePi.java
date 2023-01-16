package pi;

public class CalculatePi {

	private int shots;

	public CalculatePi(int shots) {
		this.shots = shots;
		System.out.println(/*"Pi = " + */ generateSimulation());
	}

	private double generateSimulation() {
		double sumPi = 0;
		for (int i = 0; i < this.shots; i++) {
			if (calculateDistance((Math.random() * (1 - 0)), (Math.random() * (1 - 0))) <= 1) {
				sumPi ++;
			}
		}
		return 4 * (sumPi/this.shots);
	}

	private double calculateDistance(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) +  Math.pow(y, 2));
	}
}
