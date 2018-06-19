package application;

import java.util.ArrayList;

public class Salat extends Order{

	private ArrayList<salatAuswahl> auswahl = new ArrayList<>();
	
	public Salat(String name, float price, ArrayList<salatAuswahl> auswahl) {
		super(name, price);
		this.auswahl = auswahl;
	}
	
	public ArrayList<salatAuswahl> getAuswahl(){
		return this.auswahl;
	}

}
