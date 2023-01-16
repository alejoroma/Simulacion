package model;

import java.util.ArrayList;

public class Congruencia {

	public ArrayList<Double> generatePseudorandomNumbers(int multiplicador, int incrementador, int modulo, int seed, int totalNumeros) {
		ArrayList<Double> randomNumbers = new ArrayList<Double>();
		int newSeed;
		double randomNumber;
		for (int i = 0; i < totalNumeros; i++) {
			newSeed = (multiplicador * seed + incrementador)%modulo;
			randomNumber = (double)newSeed/(modulo - 1);
			if(!randomNumbers.contains(randomNumber)) {
				randomNumbers.add(randomNumber);
			}
			seed = newSeed;
		}
		return randomNumbers;
	}
}