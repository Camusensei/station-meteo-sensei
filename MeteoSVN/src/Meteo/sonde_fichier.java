package Meteo;


public class sonde_fichier extends sonde {

		
		/**
		 */
		public sonde_fichier(String file){
		}
		void setData(Object param){
		   //obs.setChanged(); // Positionne son indicateur de changement
		    obs.notifyObservers(param); // (1) notification
		  }


}
