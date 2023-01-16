package test;

import java.util.ArrayList;

public class Persona {
	private int id;
	private int nContactos;
	private int contactosActuales;
	private ArrayList<Integer> listIdContactos;
	private int tiempoConsulta;
	private boolean recibido;
	private boolean probabilidadCompartir;
	private boolean yaCompa;
	public Persona(int id, int nContactos, int tiempoConsulta, boolean probabilidadCompartir) {
		super();
		this.id = id;
		this.nContactos = nContactos;
		listIdContactos= new ArrayList<>();
		this.contactosActuales=0;
		recibido=false;
		this.tiempoConsulta = tiempoConsulta;
		this.probabilidadCompartir = probabilidadCompartir;
		this.yaCompa = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getnContactos() {
		return nContactos;
	}
	public void setnContactos(int nContactos) {
		this.nContactos = nContactos;
	}
	public int getContactosActuales() {
		return contactosActuales;
	}
	public void setContactosActuales(int contactosActuales) {
		this.contactosActuales = contactosActuales;
	}
	public int getTiempoConsulta() {
		return tiempoConsulta;
	}
	public void setTiempoConsulta(int tiempoConsulta) {
		this.tiempoConsulta = tiempoConsulta;
	}
	public boolean getProbabilidadCompartir() {
		return probabilidadCompartir;
	}
	public void setProbabilidadCompartir(boolean probabilidadCompartir) {
		this.probabilidadCompartir = probabilidadCompartir;
	}
	public boolean isYaCompa() {
		return yaCompa;
	}
	public void setYaCompa(boolean yaCompa) {
		this.yaCompa = yaCompa;
	}
	public boolean getRecibido() {
		return recibido;
	}
	public void setRecibido(boolean recibido) {
		this.recibido=recibido;
	}
	public ArrayList<Integer> getListContactos(){
		return listIdContactos;
	}
	public void addIdContact(int idContact) {
		
		listIdContactos.add(idContact);
	}

}
