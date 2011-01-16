package Interfaces;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Capteur.Station;

public class Console {

	private Station station;

	private class MiseaJour extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Fin du run");
				}
				String vit = station.getVitesse().getValeur();
				String pression = station.getPression().getValeur();
				String sens = station.getSensvent().getValeur();
				String temp = station.getTemperature().getValeur();
				String hum = station.getHumidite().getValeur();

				Date actuelle = new Date();
				DateFormat dateFormat = new SimpleDateFormat(
						"dd/MM/yyyy hh:mm:ss");
				String dat = dateFormat.format(actuelle);

				System.out.println("");
				System.out.println("");
				System.out.println(dat);
				System.out.println("");
				System.out.print("Température : ".concat(temp).concat(" °C").concat(", Variation : ").concat(Double.toString(station.getTemperature().tendance())));
				System.out.println(", Minimum : ".concat(Double.toString(station.getTemperature().getMinimum())));
				System.out.println("Pression : ".concat(pression)
						.concat(" hPa"));
				System.out.println("Sens du vent : ".concat(sens).concat(""));
				System.out.println("Vitesse du vent : ".concat(vit).concat(
						" km/h"));
				System.out.println("Humidité : ".concat(hum).concat(" %"));
			}

		}
	}

	public Console(Station station) {
		System.out.println("Hello World!");
		
		this.station = station;

		MiseaJour miseajour = new MiseaJour();
		miseajour.start();
		//while (miseajour.isAlive()) {
			/*
			 * System.out.print("Température sonde exté : |");
			 * System.out.print(sonde_temp.getValeur());
			 * System.out.println("|");
			 * System.out.print("Température capteur exté : |");
			 * System.out.print(therm.getValeur_base());
			 * System.out.println("|");
			 * System.out.print("Température capteur exté : |");
			 * System.out.print(therm.getValeur()); System.out.println("|");
			 */
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/

		//System.out.println("Fin du run");
	}
}
