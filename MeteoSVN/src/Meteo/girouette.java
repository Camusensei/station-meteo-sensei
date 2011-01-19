package Meteo;

import java.util.Observable;

public class girouette extends Capteur_base {

	/**
	 * Instantiates a new girouette.
	 *
	 * @param observable l'observable associ�
	 * @throws Exception l'�ventuelle exception
	 */
	public girouette(Observable observable) throws Exception {
		super(Preparation.unit�s_direction, "Girouette", observable);
	}

}
