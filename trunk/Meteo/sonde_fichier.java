package Meteo;


public class sonde_fichier extends sonde {

		
		/**
		 */
		public sonde_fichier(String file){
		}
		void setData(Object param){
		    setChanged(); // Positionne son indicateur de changement
		    notifyObservers(param); // (1) notification
		  }


}
