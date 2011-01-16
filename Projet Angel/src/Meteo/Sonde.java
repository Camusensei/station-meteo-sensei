package Meteo;

import java.util.Observable;

public abstract class Sonde extends Observable implements Runnable {

	protected double valeur=0.0;

	public void run() {};

	public abstract double fetch_Value();

	public double getValeur() {
		System.out.println(valeur);
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	
	
}
