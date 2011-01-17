package Meteo;

import java.util.Observable;

public class girouette extends Capteur_base {

	public girouette(Observable observable) throws Exception {
		super(Preparation.unités_direction, "Girouette", observable);
	}

}
