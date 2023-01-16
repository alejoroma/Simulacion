package borrachoCaminando;

import java.util.Random;

public class Caminata {
	
	private int cuadras;

	public Caminata (int cuadras) {
		this.cuadras = cuadras;
	}
	
	private Boolean takeAWalk(int destinoX, int destinoY) {
		boolean isOrigin = false;
		 int x = 0, y = 0;
		Random r = new Random();
		for (int i = 0; i < this.cuadras; i++) {
			boolean dir = r.nextBoolean();
			if(dir) {
				if(r.nextBoolean()) {
					x ++;
				}
				else {
					x--;
				} 
					
			}else {
				if(r.nextBoolean()) {
					y ++;
				}
				else {
					y--;
				} 			
			}
//			System.out.println("X: " + x + "  Y: " + y);	
		
		}
		if (x == destinoX && y == destinoY) {
			isOrigin = true;
		}
//		System.out.println(isOrigin);
		return isOrigin;
		}
	
	public double returnProbabilit(int rep,int origenX, int origenY) {
		int success =0;
		for (int i = 0; i < rep; i++) {
			if(takeAWalk(origenX,origenY)) {
				success ++;
			}
		}
//		System.out.println("Cuantas veces: " + success + "  por cada: " + rep);
		return (double) success/rep;
	}
	
	
	
}
