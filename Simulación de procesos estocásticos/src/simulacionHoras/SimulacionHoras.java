package simulacionHoras;

import java.util.Random;

public class SimulacionHoras {

	private Random random;
	private double list[], listProb[];
	private int listCount[];


	public SimulacionHoras() {
		this.random = new Random();
		this.list = new double[360];
		this.listProb = new double[360];
		this.listCount = new int[29];
		generateAleatList();
		compareListToTableDistribution();
//		printRes();
//		printList();
//		System.out.println("----------");
		printCount();
	}

	private void generateAleatList() {
		for (int i = 0; i < 360; i++) {
			list[i] = this.random.nextDouble();
		}
	}

	private void compareListToTableDistribution() {

		for (int i = 0; i < list.length; i++) {
			double x = this.list[i] ;
			if (x >= 0 && x< 0.016666667) {
				this.listProb[i] = 2;
				this.listCount[0] += +1;
			}
			if (x >= 0.016666667 && x< 0.030555556) {
				this.listProb[i] = 4;
				this.listCount[1] += +1;
			}
			if (x >= 0.030555556 && x< 0.055555556) {
				this.listProb[i] = 5;
				this.listCount[2] += +1;
			}
			if (x >= 0.055555556 && x< 0.088888889) {
				this.listProb[i] = 9;
				this.listCount[3] += +1;
			}
			if (x >= 0.088888889 && x< 0.119444444) {
				this.listProb[i] = 12;
				this.listCount[4] += +1;
			}
			if (x >= 0.119444444 && x< 0.166666667) {
				this.listProb[i] = 11;
				this.listCount[5] += +1;
			}
			if (x >= 0.166666667 && x< 0.222222222) {
				this.listProb[i] = 17;
				this.listCount[6] += +1;
			}
			if (x >= 0.222222222 && x< 0.263888889) {
				this.listProb[i] = 20;
				this.listCount[7] += +1;
			}
			if (x >= 0.263888889 && x< 0.333333333) {
				this.listProb[i] = 15;
				this.listCount[8] += +1;
			}
			if (x >= 0.333333333 && x< 0.416666667) {
				this.listProb[i] = 25;
				this.listCount[9] += +1;
			}
			if (x >= 0.416666667 && x< 0.486111111) {
				this.listProb[i] = 30;
				this.listCount[10] += +1;
			}
			if (x >= 0.486111111 && x< 0.566666667) {
				this.listProb[i] = 25;
				this.listCount[11] += +1;
			}
			if (x >= 0.566666667 && x< 0.644444444) {
				this.listProb[i] = 29;
				this.listCount[12] += +1;
			}
			if (x >= 0.644444444 && x< 0.713888889) {
				this.listProb[i] = 28;
				this.listCount[13] += +1;
			}
			if (x >= 0.713888889 && x< 0.755555556) {
				this.listProb[i] = 25;
				this.listCount[14] += +1;
			}
			if (x >= 0.755555556 && x< 0.813888889) {
				this.listProb[i] = 15;
				this.listCount[15] += +1;
			}
			if (x >= 0.813888889 && x< 0.85) {
				this.listProb[i] = 21;
				this.listCount[16] += +1;
			}
			if (x >= 0.85 && x< 0.886111111) {
				this.listProb[i] = 13;
				this.listCount[17] += +1;
			}
			if (x >= 0.886111111 && x< 0.916666667) {
				this.listProb[i] = 13;
				this.listCount[18] += +1;
			}
			if (x >= 0.916666667 && x< 0.95) {
				this.listProb[i] = 11;
				this.listCount[19] += +1;
			}
			if (x >= 0.95 && x< 0.961111111) {
				this.listProb[i] = 12;
				this.listCount[20] += +1;
			}
			if (x >= 0.961111111 && x< 0.972222222) {
				this.listProb[i] = 4;
				this.listCount[21] += +1;
			}
			if (x >= 0.972222222 && x< 0.983333333) {
				this.listProb[i] = 4;
				this.listCount[22] += +1;
			}
			if (x >= 0.983333333 && x< 0.988888889) {
				this.listProb[i] = 4;
				this.listCount[23] += +1;
			}
			if (x >= 0.988888889 && x< 0.991666667) {
				this.listProb[i] = 2;
				this.listCount[24] += +1;
			}
			if (x >= 0.991666667 && x< 0.997222222) {
				this.listProb[i] = 1;
				this.listCount[25] += +1;
			}
			if (x >= 0.997222222 && x< 1) {
				this.listProb[i] = 1;
				this.listCount[26] += +1;
			}
		}
	}
	
	private void printRes() {
		for (int i = 0; i < listProb.length; i++) {
			System.out.println(listProb[i]);
		}
	}
	private void printCount() {
		for (int i = 0; i < listCount.length; i++) {
			System.out.println(listCount[i]);
		}
	}
	private void printList() {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}