package Meteo;

import java.util.List;
import java.util.Observable;

public class thermom�tre extends Capteur_pmt {

	public thermom�tre(List<unit> unit�s, String name, Observable observable,
			float mem_max, float mem_min, float plage_min, float plage_max,
			float[] last5, int where, boolean init) throws Exception {
		super(unit�s, name, observable, plage_min, plage_max);
		// TODO Auto-generated constructor stub
	}

}
