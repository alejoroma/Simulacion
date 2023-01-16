package ganaCarro;

import java.util.Iterator;
import java.util.Random;

public class GanaCarro {

	Random random;
	int doorWinner;
	int selectDoor;

	public GanaCarro() {
		this.random = new Random();
		this.doorWinner =1 + random.nextInt(4 - 1);
//		System.out.println("doorWinner= "+ doorWinner);
		this.selectDoor =1 + random.nextInt(4 - 1);
//		System.out.println("selectDoor= "+ selectDoor);
//		System.out.println("la otra puerta= "+ showOtherDoor());
//		gano(cambio);
	}
	

	public int showOtherDoor() {
		int ret = 0;
		if (doorWinner == selectDoor) {
			if(doorWinner == 1) {
				Boolean bol = random.nextBoolean();
				if (bol == true) {
					ret = 2;
				}else {
					ret = 3;
				} 
			}
			if(doorWinner == 2) {
				Boolean bol = random.nextBoolean();
				if (bol == true) {
					ret = 1;
				}else {
					ret = 3;
				} 
			}
			if(doorWinner == 3) {
				Boolean bol = random.nextBoolean();
				if (bol == true) {
					ret = 1;
				}else {
					ret = 2;
				} 
			}
		}else {
			if (doorWinner ==1 && selectDoor == 2) {
				ret = 3;
			}
			if (doorWinner ==1 && selectDoor == 3) {
				ret = 2;
			}
			if (doorWinner ==2 && selectDoor == 1) {
				ret = 3;
			}
			if (doorWinner ==2 && selectDoor == 3) {
				ret = 1;
			}
			if (doorWinner ==3 && selectDoor == 1) {
				ret = 2;
			}
			if (doorWinner ==3 && selectDoor == 2) {
				ret = 1;
			}
			
		}
		return ret;
	}
	
	public boolean gano(boolean cambio) {
		boolean gano= false;
		if (cambio == false) {
			if (doorWinner == selectDoor) {
				gano = true;
			}
		}else {
			if (doorWinner != selectDoor) {
				gano = true;
			}
			
		}
		return gano;
	}
}


