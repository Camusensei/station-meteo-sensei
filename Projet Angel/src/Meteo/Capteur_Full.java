package Meteo;

import java.util.Collection;
//import java.util.Observable;


public abstract class Capteur_Full extends Capteur_PlageMinmax implements
		I_capteur_Trend {

	private float[] memory;
	private int mod=0;

		
	public Capteur_Full(String formatval, String symbol, String descr,
			double value, String iD, Collection<unit> unites, float capteurMax,
			float capteurMin, float plageMax, float plageMin) {
		super(formatval, symbol, descr, value, iD, unites, capteurMax,
				capteurMin, plageMax, plageMin);
	}
	public String get_trend() {
		float bob=get_trend_value();
		if (bob < -5) {return "Baisse violente";}
		if (bob < 0) {return "En baisse";}
		if (bob < 5) {return "En  hausse";}
		else {return "Hausse violente";}
	}

	
	public float get_trend_value() {
		int i; float res=0;
		for (i = 0; i < 5; i++) {
			int count=0;
			if (memory[i]!=0) {count++; res+=memory[i];}
			res=res/count;
		}
		return res;
	}
	

	public void clear_trend() {
		int i;
		for (i = 0; i < 5; i++)
			memory[i] = 0;
	}

	//public double get_valeur() {System.out.println(value);return value;}
	
	public void set_trend (float f) {
		if (mod<=4) {memory[mod]=f; mod++;}
		else {
			for (int i=0;i<4;i++) {memory[i]=memory[i+1];}
			memory[4]=f;
		}
	}

}






