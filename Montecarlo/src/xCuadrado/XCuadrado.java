package xCuadrado;

public class XCuadrado {

	private int lim0, limF, shots, hits;

	public XCuadrado(int lim0, int limF, int shots) {
		super();
		this.lim0 = lim0;
		this.limF = limF;
		this.shots = shots;
		for (int i = 0; i < shots; i++) {
			calculate();
		}
	}

	private void calculate() {
		Coordante coordante = new Coordante(Math.random()* (limF - lim0), Math.random()* (limF - lim0));
//		System.out.println(coordante.getX() + " , " + coordante.getY());
		double yCalculate = Math.pow(coordante.getX(), 2);
		if (coordante.getY() <=yCalculate) {
			hits++;
		}
	}
	
	public double getArea() {
//		System.out.println("hits: " + hits);
//		System.out.println("shots: " + shots);
		return (double)hits/ shots;
	}
}