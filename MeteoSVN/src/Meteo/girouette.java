package Meteo;

import java.util.Observable;

public class girouette extends Capteur_base {

	/**
	 * Instantiates a new girouette.
	 *
	 * @param observable l'observable associé
	 * @throws Exception l'éventuelle exception
	 */
	public girouette(Observable observable) throws Exception {
		super(Preparation.unités_direction, "Girouette", observable);
	}

}
