package random;
// cuadrados medios 
public class MyRandom {
	
	private int size;
	private int seed;
	private int count;
	private int[] record;
	
	public MyRandom(int size) {
		this.size = size;
		this.seed = (int) (System.nanoTime() % Math.pow(10, size));
		this.record = new int[1000];
		this.count = 0;
	}
	
	public  double next() {
		int Value1 = this.seed * this.seed;
		//calcular cuadrados medios 
		int dif = (length(Value1) - size)/2;
		Value1 = (int) ((Value1 / Math.pow(10, dif)) % Math.pow(10, size));
		this.seed = Value1;
		//verificar si el numero ya salio previamente
		// si ya salio quiere decir que va a haver un periodo
		// deveriamos reiniciar la semilla
		count++;
		record[count] += Value1;
		if (count > 0) {
			for (int i = 0; i < count-1; i++) {
				if (Value1 == record[i]) {
					this.seed = (int) (System.nanoTime() % Math.pow(10, size));
					for (int j = 0; j < record.length; j++) {
						record[j] = 0;
			        }
					count = 0;
				}
			}
		}
		
		return seed / Math.pow(10, size);
	}
	
	public int length(int Value) {
		int count;
		for ( count = 1;Value >= 10; count++) {
			Value/=10;
		}
		
		return count;
	}
// mi solucion
	public int getDecimals(int value) {
		int decimals = 0;
		while (value != 0 ) {
			value = value/10;
			decimals++;
		}		
		return decimals;
	}

}
