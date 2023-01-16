package model;

public class Agent extends Thread {
	
	//TIEMPO EN MILISEGUNTOS para moverse.
	private static final long REFRESH_TIME = 10;
	
	private Coordenate coordenate;
	private double size;
	private double direction;
	private double speed;
	
	public Agent(Coordenate coordenate, double size, double direction, double speed) {
		super();
		this.coordenate = coordenate;
		this.size = size;
		this.direction = direction;
		//velocidad en unidades de distancia por segundo = distance/ time
		this.speed = speed;
	}
	@Override
	public void run() {
		while (true) {
			Move();
			try {
				Thread.sleep(REFRESH_TIME);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public void Move() {
		//distancia en unidades de longitud *100 por unidades a segundo
		this.coordenate.move(speed*REFRESH_TIME* 1000, direction);
		System.out.println(this.coordenate.x + " ! " + this.coordenate.y);
	}
}
