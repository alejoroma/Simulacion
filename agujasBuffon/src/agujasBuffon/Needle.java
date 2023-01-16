package agujasBuffon;

import java.util.Random;

public class Needle {
	
	private Coordante init;
	private Coordante fin;
	Random r = new Random();
	int n = r.nextInt(10 - 0);
	
	public Needle() {
		this.init = new Coordante(r.nextInt(10 - 0), r.nextInt(10 - 0));
		this.fin = new Coordante(r.nextInt(10 - 0), r.nextInt(10 - 0));
		System.out.println(init.getX() + " , " + init.getY());
		System.out.println(fin.getX()+ " , " + fin.getY());
	}
	
	public double calculateDistance() {
		return Math.sqrt(Math.pow((fin.getX()-init.getX()), 2) +  Math.pow((fin.getY()-init.getY()), 2));
	}

}
