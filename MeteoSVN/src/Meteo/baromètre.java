package Meteo;

import java.util.Observable;

public class barom�tre extends Capteur_pmt {

	public barom�tre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unit�s_pressions, "Barom�tre", observable, plage_min,
				plage_max);
	}

}
