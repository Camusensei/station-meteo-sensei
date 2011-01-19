package Meteo;

import java.util.Observable;

public class thermomètre extends Capteur_pmt {

	/**
	 * Instantiates a new thermomètre.
	 * 
	 * @param observable l'observable associé
	 * @param plage_min la plage minimale de fonctionnement
	 * @param plage_max la plage maximale de fonctionnement
	 * @throws Exception l'éventuelle exception
	 */
	public thermomètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_températures, "Thermomètre", observable,
				plage_min, plage_max);
	}

}
