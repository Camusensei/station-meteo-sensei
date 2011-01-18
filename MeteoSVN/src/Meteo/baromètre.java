package Meteo;

import java.util.Observable;


/**
 * La classe barom�tre.
 */
public class barom�tre extends Capteur_pmt {

	/**
	 * Instantiates a new barom�tre.
	 *
	 * @param observable l'observable associ�
	 * @param plage_min la plage minimale de fonctionnement
	 * @param plage_max la plage maximale de fonctionnement
	 * @throws Exception l'�ventuelle exception
	 */
	public barom�tre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unit�s_pressions, "Barom�tre", observable, plage_min,
				plage_max);
	}

}
