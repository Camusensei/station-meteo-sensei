package Meteo;

import java.util.Observable;

public class anemom�tre extends Capteur_pm {

	public anemom�tre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unit�s_vitesses, "An�mom�tre", observable, plage_min,
				plage_max);
	}

}
