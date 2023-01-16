package pi;

public class TestPi {

	public static void main(String[] args) {
		long timeInit = System. currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			CalculatePi  calculatePi = new CalculatePi(1000);
		}
		
		System.out.println("Time= " + (System. currentTimeMillis() - timeInit) + " Milisegundos");
		
	}
}
