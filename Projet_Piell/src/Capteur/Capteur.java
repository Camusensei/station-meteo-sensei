package Capteur;

import java.util.Observable;

import Sonde.Sonde;
import Unite.Unite;

public class Capteur extends AbstractCapteur {

	@Override
	public void update(Observable sonde, Object val) {
		Sonde sonde2 = new Sonde(0, 0, 0);
		if (sonde.getClass().equals(sonde2.getClass())) {
			setValeur(((Sonde) sonde).getValeur());
			notifyObservers(this.getValeur());
		}
	}

	public Capteur(Unite u, String nom) {
		super(u, nom);
	}

	public boolean chgt_Unite(Unite u) {
		if (getUnite().convert(getValeur_base(), u).equals("")) {
			return false;
		} else {
			setUnite_act(u);
		}
		return true;
	}

	public String getValeur() {
		return getUnite().convert(super.getValeur_base(), getUnite_act());
	}

}
