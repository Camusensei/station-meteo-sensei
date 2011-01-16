import Capteur.Anemometre;
import Capteur.Barometre;
import Capteur.Girouette;
import Capteur.Hygrometrie;
import Capteur.Station;
import Capteur.Thermometre;
import Interfaces.Affichage;
import Sonde.Sonde;
import Unite.Humidite;
import Unite.Pression;
import Unite.Sens_vent;
import Unite.Temperature;
import Unite.Unite;
import Unite.Vitesse;


public class Main {
	public static void main (String[] args) {
	Unite temperature = new Temperature("CEL");
	Unite pression = new Pression("hPa");
	Unite sens_vent = new Sens_vent("RAD");
	Unite vitesse = new Vitesse("KMH");
	Unite humidite = new Humidite("PRC");

	Girouette gir = new Girouette(sens_vent, "Coq");
	Thermometre therm = new Thermometre(temperature, "Robert", -15.0, 150.0, 5);
	Barometre baro = new Barometre(pression, "Coco", 900.0, 1200.0, 20);
	Anemometre anemo = new Anemometre(vitesse, "Anemone", 0.0, 150.0);
	Hygrometrie hygro = new Hygrometrie(humidite, "!troll", 0.0, 100.0);
	//gir.chgt_Unite(sens_vent_dir);

	
	Sonde sonde_temp = new Sonde(-40.0, 60.0, 4.0, 2,therm);
	Sonde sonde_pression = new Sonde(1000.0, 1200.0, 20.0, 3,baro);
	Sonde sonde_sens = new Sonde(-100.0, 100.0, Math.PI, 10,gir);
	Sonde sonde_vitesse = new Sonde(0.0, 120.0, 10.0, 15,anemo);
	Sonde sonde_humidite = new Sonde(0.0, 100.0, 10.0, 20,hygro);
	
	/*sonde_temp.addObserver(therm);
	sonde_pression.addObserver(baro);
	sonde_sens.addObserver(gir);
	sonde_vitesse.addObserver(anemo);
	sonde_humidite.addObserver(hygro);*/
	
	sonde_temp.start();
	sonde_pression.start();
	sonde_sens.start();
	sonde_vitesse.start();
	sonde_humidite.start();

	Station station = new Station();
	station.add(gir);
	station.add(therm);
	station.add(baro);
	station.add(anemo);
	station.add(hygro);
	
	//Console fen = new Console(station);
	Affichage fen2 = new Affichage(station);

	}
}
