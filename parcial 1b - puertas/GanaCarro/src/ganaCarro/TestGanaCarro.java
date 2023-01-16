package ganaCarro;

import java.util.Iterator;

public class TestGanaCarro {

	public static void main(String[] args) {
		
		for (int k = 0; k < 1000; k++) {
			int cuantasGano= 0;
			
			for (int i = 0; i < 1000; i++) {
				GanaCarro ganaCarro = new GanaCarro();
				//cambiar a false si no quiere cambiar la escojida y a true si cambia la escojida
				if(ganaCarro.gano(true) == true) {
					cuantasGano++;
				}
			}
			System.out.println(cuantasGano);
			
		}
	}
}
