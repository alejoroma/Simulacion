package lendLease;

public class Test {

	public static void main(String[] args) {
		long valorInicial = 100000;
		LendLease lendLease = new LendLease(valorInicial);
		lendLease.calculateForYear(valorInicial, 3);//calculo por 3 anios con 100.000
		lendLease.howTime(valorInicial, 100000000);
		lendLease.calculateForYear(1000000, 3); //calculo por 3 anios con 1.000.000
		
	}
}