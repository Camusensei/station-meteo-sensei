package Capteur;

import java.util.Observable;

import Sonde.Sonde;
import Unite.Unite;

public class Girouette extends Capteur {

	@Override
	public void update(Observable sonde, Object val) {
		Sonde sonde2 = new Sonde(0, 0, 0);
		if (sonde.getClass().equals(sonde2.getClass())) {
			sonde2 = (Sonde) sonde;
			double val2 = sonde2.getValeur();
			if (val2 > 2 * Math.PI) {
				int k = (int) (val2 / (2 * Math.PI));
				val2 = (val2 - k * (2 * Math.PI));
				notifyObservers(this.getValeur());
			} else if (val2 < 0) {
				int k = (int) (val2 / (2 * Math.PI));
				val2 = (val2 - (k - 1) * (2 * Math.PI));
				notifyObservers(this.getValeur());
			}
			setValeur(val2);
		}
	}

	public Girouette(Unite u, String nom) {
		super(u, nom);
	}

}
