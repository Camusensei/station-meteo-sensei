package Meteo;

import java.util.Observable;

public class hygrom�tre extends Capteur_pm {

	public hygrom�tre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unit�s_humidit�, "Hygrom�tre", observable, plage_min,
				plage_max);
	}

}
