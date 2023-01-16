package halfSquares;

import java.util.ArrayList;

public class MyRandom {
	private int size;
	private int seed;
	private int repetitions = 100;
	private ArrayList<Double> alNum;

	public MyRandom(int size) {
		this.size = size;
		this.seed = (int) (System.nanoTime() %Math.pow(10, size));
		this.alNum = new ArrayList<>();
	}

	private double next() {
		int value = this.seed* this.seed;
		int dif = (length(value)-size)/2;
		value = (int) (value / Math.pow(10, dif)) % (int) Math.pow(10, size);
		this.seed = value;
		double numAl = seed/Math.pow(10, size);
		//Verificar si el # ya salio
		//si ya salio reiniciar la semilla
		return numAl;
	}

	public double makeProcess() {
		while(alNum.size() < repetitions) {
			double aux = next();
			if (!alNum.contains(aux)) {
				this.alNum.add(aux);
//							System.out.println("i: " + alNum.size() + " num: " + aux);
			}else {
				//si ya salio reiniciar la semilla
				this.seed = (int) (System.nanoTime() %Math.pow(10, size));
				this.alNum = new ArrayList<>();
				System.out.println("Se reinicio por: " + aux);
			}
		}
		return alNum.get(repetitions-1);
	}
	
	public ArrayList<Double> getAlNum() {
		return alNum;
	}

	private int length(int value) {
		int count =1;
		for (int i = 1;  value>=10 ; i++) {
			value /=10;	
			count ++;
		}
		return count;

	}
}
//diferencia divido en 2 
//metodos congruenciales semilla(multiplicacion y modulos)