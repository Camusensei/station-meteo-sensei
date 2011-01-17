package Meteo;

import Meteo.Preparation;

public class Launcher {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Preparation.create_units();
		Meteo.fenêtre.draw(null);
	}

}
