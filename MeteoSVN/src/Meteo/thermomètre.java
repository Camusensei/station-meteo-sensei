package Meteo;

import java.util.Observable;

public class thermomètre extends Capteur_pmt {

	public thermomètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_températures, "Thermomètre", observable,
				plage_min, plage_max);
	}

}
