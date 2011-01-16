package Meteo;

import java.util.Collection;
//import java.util.Observable;

public abstract class Capteur_PlageMinmax extends Capteur_Minmax implements
		I_capteur_Plage {

	private float plage_min = 0;
	private float plage_max = 0;
	
	public Capteur_PlageMinmax(String formatval, String symbol, String descr,
			double value, String iD, Collection<unit> unites, float capteurMax,
			float capteurMin, float plageMax, float plageMin) {
		super(formatval, symbol, descr, value, iD, unites, capteurMax,
				capteurMin);
		plage_min = plageMin;
		plage_max = plageMax;
	}

	public float getPlage_min() {return plage_min;}

	public void setPlage_min(float plage_min) {
		this.plage_min = plage_min;
	}

	public float getPlage_max() {return plage_max;}

	public void setPlage_max(float plage_max) {
		this.plage_max = plage_max;
	}
}
