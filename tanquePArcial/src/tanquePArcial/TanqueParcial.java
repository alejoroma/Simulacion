package tanquePArcial;

public class TanqueParcial {
	
	private double v = 19.3495 ;//volumen pi*r^2*h en metros cubicos
	private double vel = 4.42;
	
	public TanqueParcial() {
	}
	
	public double calculeTime() {
		double caudal = 0;
		int time = 0;
		double areaAgujero = 0.1;
		
		while (caudal <19.3495) {
			double auxCaudalsito = (3.1416* Math.pow(areaAgujero, 2) )* vel;
			caudal += auxCaudalsito;
//			System.out.println("caudal " + caudal);
			time ++;
			areaAgujero = areaAgujero + 0.1;
			
		}
		return time;		
	}
	
	

}
