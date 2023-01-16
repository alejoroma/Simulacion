package second;

public class Colision {

	private double x0, x1, y0, y1;
	private double m0, m1, rX , rY;
	private double ey0[], ey1[];
	private Point point0, point1;

	public Colision(Point point0, Point point1) {
		this.x0 = point0.getX();
		this.x1 = point1.getX();
		this.y0 = point0.getY();
		this.y1 = point1.getY();
		ey0 = new double[2];
		ey1 = new double[2];
		this.point0 = point0;
		this.point1 = point1;
		init();
	}
	/**
	 * Metodo que inicializa los metodos de simulacion
	 */
	private void init() {
		calculateM();
		calculateEquation();
		calculateIntersection();
	}

	private void calculateM() {
		m0 = getTanDeg(point0.getAngle());
		m1 = getTanDeg(point1.getAngle());

		if(point0.getAngle() == 180) {
			m0 = 0;
		}
		if(point1.getAngle() == 180) {
			m1 = 0;
		}
		System.out.println(" m0: "  + m0);
		System.out.println(" m1: "  + m1);
	}

	private double getTanDeg(double deg) {
		var rad = deg * Math.PI/180;
		return Math.tan(rad);
	}


	//asigna el valor de la recta en posiciones del vector de ecuacion 
	//Para que sea mas facil operar
	private void calculateEquation() {
		ey0[0] = m0;
		ey0[1] = y0;

		ey1[0] = m1;
		ey1[1] = y1;
	}


	private void calculateIntersection() {
		double c = ey0[0]- ey1[0];
		double v = ey0[1]- ey1[1];
		rX = c + v;

		double n = ey0[0]* rX;
		rY = n + ey0[1];
	}

	public double getrX() {
		return rX;
	}

	public void setrX(double rX) {
		this.rX = rX;
	}

	public double getrY() {
		return rY;
	}

	public void setrY(double rY) {
		this.rY = rY;
	}

	private double calculateDistance(Point point) {
		double x = toPositive(point.getX());
		double xr = toPositive(getrX());

		double y = toPositive(point.getY());
		double yr = toPositive(getrY());

		double xf = Math.pow(x- xr,2);
		double yf = Math.pow(y- yr,2);
		return Math.sqrt(xf - yf);
	}

	private double toPositive(double num) {
		double aux = num ;
		if (aux< 0) {
			aux = aux * (-1);	
		}
		return aux;
	}
	private double calculateTime(Point point) {
		return calculateDistance(point) / point.getSpeed();
	}

	public boolean isColision() {
		boolean rta = false;
		double time1 = calculateTime(this.point0);
		double time2 = calculateTime(this.point1); 

		System.out.println("Time 1"+  time1);
		System.out.println("Time 2"+  time2);

		if (time1 == time2) {
			rta= true;
		}
		if (m0 == m1) {
			rta= true;
		}
		if (point0.getX() == point1.getX() && point0.getY() == point1.getY()) {
			rta= true;
		}

		return rta;
	}
}
