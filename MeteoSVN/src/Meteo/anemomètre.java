package Meteo;

import java.util.List;
import java.util.Observable;

public class anemomètre extends Capteur_pm {

	public anemomètre(List<unit> unités, String name, Observable observable,
			float mem_max, float mem_min, float plage_min, float plage_max)
			throws Exception {
		super(unités, name, observable, mem_max, mem_min, plage_min, plage_max);
	}

}
