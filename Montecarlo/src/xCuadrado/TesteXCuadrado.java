package xCuadrado;

public class TesteXCuadrado {

	public static void main(String[] args) {
		long timeInit = System. currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			XCuadrado xCuadrado = new XCuadrado(0, 1, 1000000);
			System.out.println(xCuadrado.getArea());
		}
		System.out.println("Time= " + (System. currentTimeMillis() - timeInit) + " Milisegundos");

		
	}
}
