package Meteo;

import Meteo.Preparation;

public class Launcher {

	/**
	 * Lance le programme complet, avec l'interface graphique
	 * @param args non utilis�s
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Preparation.create_units();
		Meteo.fen�tre.draw(null);
	}

}
