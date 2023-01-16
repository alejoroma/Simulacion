package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Test {
	private int nPoblacion = 35000;
	private int nPersonasContagiadas=0;
	ArrayList<Persona> listPoblacion;
	Random random;
	int idRumor;
	
	public Test() {
		listPoblacion = new ArrayList<>();
		random = new Random();
		 idRumor=random.nextInt(nPoblacion);
		crearPoblacion();
		asignarContactos();
		listPoblacion.get(idRumor).setProbabilidadCompartir(true);
		booleanComparte();
		propagacionRumor();
	}

	private void crearPoblacion() {
		for (int i = 0; i < nPoblacion; i++) {
			listPoblacion.add(new Persona(i, random.nextInt(160), random.nextInt(30), booleanComparte()));
		}
	}

	private void asignarContactos() {
		for (int i = 0; i < listPoblacion.size(); i++) {
			while (listPoblacion.get(i).getContactosActuales() < listPoblacion.get(i).getnContactos()) {
				int idC = random.nextInt(nPoblacion);
				if (listPoblacion.get(i).getContactosActuales() < listPoblacion.get(i).getnContactos()) {
					boolean yaesta = false;
					for (int k = 0; k < listPoblacion.get(i).getContactosActuales(); k++) {
						if (listPoblacion.get(i).getListContactos().get(k) == idC) {
							yaesta = true;
						}
					}
					if (!yaesta) {
						listPoblacion.get(i).addIdContact(idC);
						if (listPoblacion.get(idC).getContactosActuales() < listPoblacion.get(idC).getnContactos()) {
							listPoblacion.get(idC).addIdContact(i);
						}
					}
				}
			}
		}
	}
	
	private void propagacionRumor() {
		while(nPersonasContagiadas<(nPoblacion/2)) {
			for (int i = 0; i < listPoblacion.get(idRumor).getnContactos(); i++) {
				if(listPoblacion.get(listPoblacion.get(i).getListContactos().get(i)).getRecibido()==false) {
					listPoblacion.get(listPoblacion.get(i).getListContactos().get(i)).setRecibido(true);
					nPersonasContagiadas++;
					System.out.println("nPersonasContagiadas: " + nPersonasContagiadas);
				}	
			}	
		}
	}
	
	private Boolean booleanComparte() {
		double pro = random.nextDouble();
		return (pro > 0.35) ? false : true;
	}

	public static void main(String[] args) {
		new Test();
	}
}