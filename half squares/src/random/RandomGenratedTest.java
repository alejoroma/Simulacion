package random;

public class RandomGenratedTest {
	public static void main(String[] args) {
		MyRandom[] myRandom = new MyRandom[10];
		for (int i = 0; i < myRandom.length; i++) {
			myRandom[i] = new MyRandom(4);
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < myRandom.length; j++) {
				System.out.print(myRandom[j].next() + ";");
			}
			System.out.println();
			
		}
//		System.out.println(" " + myRandom.length(45664));
//		System.out.println(" " + myRandom.getDecimals(45664));
	}
	
	
}
