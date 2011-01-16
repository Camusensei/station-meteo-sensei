package Meteo;

import java.util.List;
import java.util.Observable;

public class thermomètre extends Capteur_pmt {

	public thermomètre(List<unit> unités, String name, Observable observable,
			float mem_max, float mem_min, float plage_min, float plage_max,
			float[] last5, int where, boolean init) throws Exception {
		super(unités, name, observable, mem_max, mem_min, plage_min, plage_max, last5,
				where, init);
		// TODO Auto-generated constructor stub
	}

}
