package Meteo;

import java.util.Observable;


/**
 * La classe baromètre.
 */
public class baromètre extends Capteur_pmt {

	/**
	 * Instantiates a new baromètre.
	 *
	 * @param observable l'observable associé
	 * @param plage_min la plage minimale de fonctionnement
	 * @param plage_max la plage maximale de fonctionnement
	 * @throws Exception l'éventuelle exception
	 */
	public baromètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_pressions, "Baromètre", observable, plage_min,
				plage_max);
	}

}
