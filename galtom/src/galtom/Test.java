package galtom;

public class Test {

	public static void main(String[] args) {
		Galtom galtom = new Galtom();
		for (int i = 0; i < 100; i++) {
			galtom.genetareNumGaltom(100);
		}
//		System.out.println(galtom.getNumGen());
		for (int i = 0; i < galtom.getNumGen().size(); i++) {
			System.out.println(galtom.getNumGen().get(i));
		}

	}

}
