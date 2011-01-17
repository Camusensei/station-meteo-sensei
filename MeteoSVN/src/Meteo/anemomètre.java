package Meteo;

import java.util.List;
import java.util.Observable;

public class anemomètre extends Capteur_pm {

	public anemomètre(List<unit> unités, String name, Observable observable,
			float plage_min, float plage_max) throws Exception {
		super(unités, name, observable, plage_min, plage_max);
	}

}
