package Meteo;

import java.util.Observable;

public class thermom�tre extends Capteur_pmt {

	public thermom�tre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unit�s_temp�ratures, "Thermom�tre", observable,
				plage_min, plage_max);
	}

}
