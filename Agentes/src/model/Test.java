package model;

public class Test {

	public static void main(String[] args) {
		Agent a1 = new Agent(new Coordenate(500, 500), 10, Math.toRadians(45), 100);
		a1.start();
	}

}
