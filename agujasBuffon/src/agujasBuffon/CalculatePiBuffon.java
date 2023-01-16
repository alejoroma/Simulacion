package agujasBuffon;

import java.util.Random;

public class CalculatePiBuffon {

	private Random random ;
	private int hits, separate, tries;

	public CalculatePiBuffon(int tries, int separate) {
		this.random =  new Random();
		this.tries = tries;
		this.separate = separate;
		this.hits = 0;
		calculatePi();
	}

	public void calculatePi() {
		for (int i = 0; i < tries; i++) {
			double y0 = random.nextDouble()*separate;
//			System.out.println("y0= " + y0);
			double angle = random.nextDouble()*180;
//			System.out.println(angle);
			double yF = y0 + Math.sin(Math.toRadians(angle));
//			System.out.println(yF);
			if (yF >= separate) {
				hits ++;
			}
		}
		double pi = (float) tries / hits;
		System.out.println(/*"Pi = " +*/ pi);
	}
}