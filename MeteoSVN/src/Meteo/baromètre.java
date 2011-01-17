package Meteo;

import java.util.Observable;

public class baromètre extends Capteur_pmt {

	public baromètre(Observable observable, float plage_min, float plage_max)
			throws Exception {
		super(Preparation.unités_pressions, "Baromètre", observable, plage_min,
				plage_max);
	}

}
