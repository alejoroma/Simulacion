package second;

public class Test {

	public static void main(String[] args) {
		Point pointA = new Point(3, 6, 0, 10);
		Point pointB = new Point(11, 6, 180, 10);
		
		Colision colision = new Colision(pointA, pointB);
		System.out.println("Coordenadas de colision: X: " +colision.getrX()+ " // Y: " +colision.getrY());
		System.out.println("Se choco? " + colision.isColision());
		
		Point pointC = new Point(1, 5, 45, 10);
		Point pointD = new Point(11, 6, 180, 10);
		System.out.println("---------------------");
		Colision colision2 = new Colision(pointC, pointD);
		System.out.println("Coordenadas de colision: X: " +colision2.getrX()+ " // Y: " +colision2.getrY());
		System.out.println("Se choco? " + colision2.isColision());
	}
}