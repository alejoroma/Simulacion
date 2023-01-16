package agujasBuffon;

public class TestBuffon {

	public static void main(String[] args) {
		long timeInit = System. currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			CalculatePiBuffon buffon = new CalculatePiBuffon(10,2);
		}
		System.out.println("Time= " + (System. currentTimeMillis() - timeInit) + " Milisegundos");
		
	}
}