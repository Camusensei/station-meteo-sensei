package Meteo;

import java.util.Observable;

public class hygromètre extends Capteur_pm {

	/**
	 * Instantiates a new hygromètre.
	 *
	 * @param observable l'observable associé
	 * @param plage_min la plage minimale de fonctionnement
	 * @param plage_max la plage maximale de fonctionnement
	 * @throws Exception l'éventuelle exception
	 */
	public hygromètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_humidité, "Hygromètre", observable, plage_min,
				plage_max);
	}

}
