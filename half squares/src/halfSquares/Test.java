package halfSquares;

public class Test {

	public static void main(String[] args) {
		MyRandom generatePseudorandom = new MyRandom(4 );
//		for (int i = 0; i < 100; i++) {
//			System.out.println(""+ generatePseudorandom.next());
//		}
		
//		System.out.println(generatePseudorandom.length(10));
		
//		System.out.println("el numero aleatorio es: " + generatePseudorandom.makeProcess());
		generatePseudorandom.makeProcess();
		
		for (int i = 0; i < generatePseudorandom.getAlNum().size(); i++) {
			System.out.println(generatePseudorandom.getAlNum().get(i));
		}			
	}
}
