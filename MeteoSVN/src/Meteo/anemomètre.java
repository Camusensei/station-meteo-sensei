package Meteo;

import java.util.Observable;

public class anemom�tre extends Capteur_pm {

	/**
	 * Instantiates a new anemom�tre.
	 *
	 * @param observable l'observable associ�
	 * @param plage_min la plage minimale de fonctionnement
	 * @param plage_max la plage maximale de fonctionnement
	 * @throws Exception l'�ventuelle exception
	 */
	public anemom�tre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unit�s_vitesses, "An�mom�tre", observable, plage_min,
				plage_max);
	}

}
