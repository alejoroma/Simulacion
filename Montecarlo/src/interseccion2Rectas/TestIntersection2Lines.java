package interseccion2Rectas;

public class TestIntersection2Lines {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Interseccion2Rectas rectas = new Interseccion2Rectas(100000);
			System.out.println(rectas.calculateArea());
		}
	}
}