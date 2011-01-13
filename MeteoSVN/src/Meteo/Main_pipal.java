package Meteo;

import java.util.Observable;

public class Main_pipal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Observable sonde1=new sonde_random(0, 10);
		Capteur_base capteur=new girouette(sonde1, "girouette_pipale");
		System.out.println(capteur);
		capteur.update(sonde1, capteur);
	}

}
