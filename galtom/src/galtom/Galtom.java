package galtom;

import java.util.ArrayList;
import java.util.Random;

public class Galtom {
	
	private ArrayList<String> numGen;
	
	
	public Galtom() {
		this.numGen = new ArrayList<>();
	}
	
	public void genetareNumGaltom(int pasadas) {
		double aux = 0.5;
		double divisor = (double) (1/((double)2*pasadas));
//		System.out.println("divisor " + divisor);
		
		for (int i = 0; i < pasadas; i++) {
			if (returnDir()) {
				aux = aux + divisor;	
			}else {
				aux = aux -divisor;
			}
		}
//		System.out.println(aux);
		numGen.add(""+ aux);
//		numGen.add(String.format("%.2f", aux));
	}
	
	public ArrayList<String> getNumGen() {
		return numGen;
	}
	
	
	
	private Boolean returnDir() {
		Random aleatrio=  new Random();
		return aleatrio.nextBoolean();
	}
	
	

}
