package ruleta;

import java.util.Random;

public class Roulette {

	public Roulette(int experimentos) {
		compare(experimentos);
//		System.out.println(launchLuckyNumber());
//		System.out.println(launchRanromNum());
	}

	public int launchLuckyNumber() {
		Random random = new Random();
		int launch = 1 ;
		int numSuerte = random.nextInt(37);
		int numLaunch = random.nextInt(37);

		while (numSuerte !=numLaunch ) {
			numLaunch = random.nextInt(37);
			launch++;
		}
		return launch;
	}

	public int launchRanromNum() {
		Random random = new Random();
		int launch = 1 ;
		int numSuerte = random.nextInt(37);
		int numLaunch = random.nextInt(47);

		while (numSuerte !=numLaunch ) {
			numSuerte = random.nextInt(37);
			numLaunch = random.nextInt(37);
			launch++;
		}
		return launch;
	}

	public void compare(int experimentos) {
		int porSuerte = 0 ;
		int porAzar = 0;

		for (int i = 0; i < experimentos; i++) {
			int l = launchLuckyNumber();
			int r = launchRanromNum();
			if (l < r) {
				//				System.out.println("suerte = " + l + " Random = "+ r);
				porSuerte++;
			}else {
				//				System.out.println("-- suerte = " + l + " Random = "+ r);
				porAzar++;
			}
		}
		if (porSuerte > porAzar) {
			System.out.println("Gano por suerte= "+ porSuerte  + " Vs " +  porAzar);

		}else {
			System.out.println("Gano por azar= "+  porAzar + " Vs " + porSuerte );
		}
	}
}
