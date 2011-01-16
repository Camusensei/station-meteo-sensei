package Meteo;

import java.util.Collection;

public class Hygrometre extends Capteur_PlageMinmax {

	public Hygrometre(String formatval, String symbol, String descr,
			double value, String iD,
			Collection<unit> unites, float capteurMax, float capteurMin,
			float plageMin, float plageMax) {
		super(formatval, symbol, descr, value, iD, unites, capteurMax,
				capteurMin, plageMin, plageMax);
	}

	
}
