package interseccion2Rectas;

public class Interseccion2Rectas {
	
	private int shots;

	public Interseccion2Rectas(int shots) {
		this.shots = shots;
	}
	
	public double calculateArea() {
		int aciertos = 0;
		for (int i = 0; i < shots; i++) {
			int n = (int) (Math.random() * (66 - 18)) + 18;
			double x=  (Math.random()*(0.506));
			double y =  (Math.random()*(0.6 - 0.4 )) + 0.4 ;
//			System.out.println("Coordenate = " + x + " , " + y);
			if (x >=0.041 && x<= 0.5051) {
				double y1 = Math.sqrt(x)/2 + (1/(x+1)) -0.5;
//				System.out.println("Y1 = " + y1);
				double y2 = Math.pow(x, 2) + (1/(x+1)) -0.4;
//				System.out.println("Y2 = " + y2);
				if (y <= y1 && y > y2){
					aciertos ++;
				}
			}
		}
//		System.out.println("aciertos = " + aciertos);
		return (double) aciertos/shots;
	}	

}
