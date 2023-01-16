package borrachoCaminando;

public class TestCaminada {

	public static void main(String[] args) {
		
		
		//System.out.println(caminata.makeSimulation());
		double probabilidad = 0;
		for (int i = 0; i < 100; i++) {
			Caminata caminata = new Caminata(10);
			probabilidad += caminata.returnProbabilit(100000, 10,0 );
//			System.out.println("Probabilidad: " + caminata.returnProbabilit(10000, 0,0 ));
//			System.out.println("---------- ");
		}	
		System.out.println("Probabilidad: " + probabilidad/100);

	}
}
