package Meteo;

import java.util.Observable;

public class anemomètre extends Capteur_pm {

	public anemomètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_vitesses, "Anémomètre", observable, plage_min,
				plage_max);
	}

}
