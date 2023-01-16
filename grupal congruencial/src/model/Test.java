package model;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public Congruencia con;
	public ArrayList<Double> arrayNumeros;

	public Test() {
		arrayNumeros = new ArrayList<Double>();
		con = new Congruencia();
		ini();

	}
	public void ini() {
		int a = 255;
		int c = 100;
		int m = 1032;
		int x = 5;
		int totaldatos = 10000;
		arrayNumeros = con.generatePseudorandomNumbers(a,c, m,x, totaldatos);
	}
	public void getNumbers() {
		for (int i = 0; i < arrayNumeros.size(); i++) {
			System.out.println(arrayNumeros.get(i));
		}
	}


	public static void main(String[] args) {
//	
//	Scanner leer = new Scanner(System.in);
//	System.out.println("Ingrese el multiplicador: ");
//	int a = leer.nextInt();
//	System.out.println("Ingrese la semilla: ");
//	int x = leer.nextInt();
//	System.out.println("Ingrese el adicionador: ");
//	int c = leer.nextInt();
//	System.out.println("Ingrese el modulo: ");
//	int m = leer.nextInt();
//	
		/*
		 * Congruencial → a: multiplicador, c: incremento, m: módulo, x0: semilla. ● x0
		 * = 5, m = 1032, a = 255, c = 100.
		 */
//	

		Test test=new Test();
		test.getNumbers();
//	
	}
}