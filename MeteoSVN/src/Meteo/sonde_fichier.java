package Meteo;

import java.util.Observable;


public class sonde_fichier extends Sonde {

		
		/**
		 */
		public sonde_fichier(String file){
		}
		void setData(Object param){
			Observable obs = new Observable();
			//obs.setChanged(); // Positionne son indicateur de changement
		    obs.notifyObservers(param); // (1) notification
		  }


}
