package first;

public class Tank {
	
	private static final double g = 9.8;
	private double A ;
	private double y1, y2, y3;
	private double speed, time;
	private double xExit;
	private double yExit;
	private double tFall;
	private double xJet;
	private double vol1, volExit;
	private double volLeft;
	
	
	public Tank(double y1, double y2,double y3, double time, double A) {
		super();
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.time = time;
		this.A = A;
		init();
	}
	/**
	 * Metodo que inicializa la logica
	 */
	
	private void init() {
		calculateSpeed();
		xExit();
		yExit();
		calculateFallTime();
		jetScope();
		calculateVolumeTotal();
		calculateVolumeExit();
		calculateVolumeLeft(0);
	}
	/**
	 * Calcula y rertona la velocidad del fluido 
	 * desprecia rozamiento
	 * presion: atmosferica
	 * @return
	 */
	
	private double calculateSpeed() {
		speed = Math.sqrt((2*g)*(y2-y1));
		System.out.println("Speed: " + speed);
		return speed;
	}
	
	/**
	 * Calcula y retorna la distancia en eje x del chorro que sale
	 */
	
	private double xExit() {
		xExit = speed* time;
		System.out.println("xExit: " + xExit);
		return xExit;
	}
	/**
	 * Calcula y retorna la distancia en eje y del chorro que sale
	 * @return
	 */
	 private double yExit() {
		yExit = y1+ y3 - (0.5*g*Math.pow(time, 2));
		System.out.println("yExit: " + yExit);
		return yExit;
	}
	/**
	 * Calcula y retorna el tiempo de caida del chorro
	 * @return
	 */
	
	private double calculateFallTime() {
		tFall =  Math.sqrt((2*(y1 + y3)/g));
		System.out.println("time Fall: " + tFall);
		return tFall;
	}
	/**
	 * Calcula y retorna  el valor de x del chorro
	 *  cuando toca el inicio del segundo tanque
	 * @return
	 */
	private double jetScope() {
		xJet = 2* Math.sqrt((y2-y1)*y1);
		System.out.println("x Jet: " + xJet);
		return xJet;
	}
	/**
	 * Calcula y retorna el volumen total del cilindro
	 * Forumula : 
	 * π r² h
	 * @return
	 */
	
	private double calculateVolumeTotal() {
		vol1 = 3.1416 * (Math.pow((A/2),2))*y2;
		System.out.println("vol initial : " + vol1);
		return vol1;
	}
	/**
	 * Calcula y retorna la tasa de salida del agua bajo la ecuacion 
	 * Forumula: 
	 * Q=Av Siendo A, area de sueperficie y v, velocidad del fluido,
	 * calculado anteriormente
	 * volumen por unidad de tiempo
	 * @return
	 */
	
	public double calculateVolumeExit() {
		volExit = 3.1416 * Math.pow((A/2),2)* speed;
		System.out.println("volExit : " + volExit);
		return volExit;
	}
	/**
	 * Calcula y retorna el volumen cuando ya ha salido algo del liquido
	 * recibe el agua que cae del otro tanque
	 * @return
	 */
	public double calculateVolumeLeft(double volumeFall) {
		volLeft= vol1 - volExit + volumeFall;
		System.out.println("volLeft : " + volLeft);
		return volLeft;
	}
}
