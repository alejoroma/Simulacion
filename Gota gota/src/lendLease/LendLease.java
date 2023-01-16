package lendLease;

public class LendLease {

	private long dinero;

	public LendLease(long cashFlow) {
		super();
		this.dinero = cashFlow;
		//monthyFee(dinero);
		//calculateForYear(dinero, 3);
	}



	private long calculatedailyFee(long cash) {
		int dailyFee = (int) ((cash + (cash * 0.1))/30) ;
		byte latest = (byte) (dailyFee%100);

		if (latest == 50 || latest == 00) {
			return dailyFee;
		}else {
			dailyFee = redondeo(dailyFee, latest);
		}
		return dailyFee;	
	}

	private int redondeo(int dailyFee, byte latest ) {
		int newFee = 0;
		if (latest < 50) {
			newFee = (dailyFee - (int) latest)+ 50 ;
		}else {
			newFee = (dailyFee - (int) latest)+ 100;
		}
		return newFee;	
	}

	private long monthyFee(long cash) {
		//System.out.println("en el monthyFee" + calculatedailyFee(cash)*30);
		return calculatedailyFee(cash)*30;
	}



	public long calculateForYear(long dinero, int anios) {
		long myCoutaMes = dinero;
		for (int i = 0; i < (12 * anios); i++) {
			myCoutaMes = monthyFee(myCoutaMes);
			//System.out.println("mes " + (i +1 )+ ": " + myCoutaMes);
		}
		System.out.println("El dinero recaudado en " + anios + " años es : $" + myCoutaMes  + "  --Con un monto inicial de " + dinero);
		return myCoutaMes;
	}

	public double howTime(long dinero, long meta) {
		long myCoutaMes = dinero;
		double month = 0;
		while (myCoutaMes < meta) {
			myCoutaMes = monthyFee(myCoutaMes);
			month ++;
		}
		//System.out.println("How time cuota mes: $" + myCoutaMes);
		System.out.println("Para reunir " + meta + " se demorara meses: " + month + "|| en años" + month/12 );
		return month;
	}
}
