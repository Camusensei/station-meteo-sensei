package Meteo;

import java.util.Observable;

public class hygromètre extends Capteur_pm {

	public hygromètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_humidité, "Hygromètre", observable, plage_min,
				plage_max);
	}

}
