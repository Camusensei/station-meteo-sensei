package Meteo;

import java.util.Collection;
//import java.util.Observable;

public abstract class Capteur_Minmax extends Capteur_meteo implements
		I_capteur_Minmax {

	
	private float capteur_max = 0;
	private float capteur_min = 0;
	
	public Capteur_Minmax(String formatval, String symbol, String descr,
			double value, String iD, Collection<unit> unites, float capteurMax,
			float capteurMin) {
		super(formatval, symbol, descr, value, iD, unites);
		capteur_max = capteurMax;
		capteur_min = capteurMin;
	}

	public float getCapteur_max() {return capteur_max;}

	public void setCapteur_max(float capteur_max) {
		this.capteur_max = capteur_max;
	}
	
	public float getCapteur_min() {
		return capteur_min;
	}

	public void setCapteur_min(float capteur_min) {
		this.capteur_min = capteur_min;
	}

}
