package Meteo;

import java.util.List;
import java.util.Observable;

public class anemom�tre extends Capteur_pm {

	public anemom�tre(List<unit> unit�s, String name, Observable observable,
			float mem_max, float mem_min, float plage_min, float plage_max)
			throws Exception {
		super(unit�s, name, observable, mem_max, mem_min, plage_min, plage_max);
	}

}
