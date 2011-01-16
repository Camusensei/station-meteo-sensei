package Interfaces;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Choice;

import Capteur.Capteur;
import Unite.Pression;
import Unite.Sens_vent;
import Unite.Temperature;
import Unite.Unite;
import Unite.Vitesse;

public class Choice_Listener implements ItemListener {

	public Capteur cap;
	
	public Choice_Listener (Capteur c) {
		cap = c;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Choice c = new Choice();
		String val = "";
		if (val.getClass().equals(arg0.getItem().getClass())) {
			val = ((String) arg0.getItem());
		}
		else {
			System.out.println("Erreur de lecture!");
		}
		Unite temperature = new Temperature("CEL");
		Unite temperature_KEL = new Temperature("KEL");
		Unite temperature_FAR = new Temperature("FAHR");
		
		Unite pression = new Pression("hPa");
		Unite pression_mmHg = new Pression("mmHG");
		Unite pression_poHg = new Pression("poHG");
		Unite pression_mB = new Pression("mB");
		
		Unite sens_vent = new Sens_vent("RAD");
		Unite sens_vent_dir = new Sens_vent("DIR");
		Unite sens_vent_deg = new Sens_vent("DEG");
		
		Unite vitesse = new Vitesse("KMH");
		Unite vitesse_ms = new Vitesse("MS");
		Unite vitesse_mh = new Vitesse("MH");
		Unite vitesse_n = new Vitesse("N");
		Unite vitesse_bf = new Vitesse("BF");
		
		if (val.equalsIgnoreCase("°C")) {
			cap.chgt_Unite(temperature);
		}
		else if (val.equalsIgnoreCase("K")) {
			cap.chgt_Unite(temperature_KEL);
		}
		else if (val.equalsIgnoreCase("°F")) {
			cap.chgt_Unite(temperature_FAR);
		}
		else if (val.equalsIgnoreCase("hPa")) {
			cap.chgt_Unite(pression);
		}
		else if (val.equalsIgnoreCase("mBar")) {
			cap.chgt_Unite(pression_mB);
		}
		else if (val.equalsIgnoreCase("mmHg")) {
			cap.chgt_Unite(pression_mmHg);
		}
		else if (val.equalsIgnoreCase("poHg")) {
			cap.chgt_Unite(pression_poHg);
		}
		else if (val.equalsIgnoreCase("rad")) {
			cap.chgt_Unite(sens_vent);
		}
		else if (val.equalsIgnoreCase("°")) {
			cap.chgt_Unite(sens_vent_deg);
		}
		else if (val.equalsIgnoreCase("Pts card")) {
			cap.chgt_Unite(sens_vent_dir);
		}
		else if (val.equalsIgnoreCase("km/h")) {
			cap.chgt_Unite(vitesse);
		}
		else if (val.equalsIgnoreCase("m/s")) {
			cap.chgt_Unite(vitesse_ms);
		}
		else if (val.equalsIgnoreCase("M/h")) {
			cap.chgt_Unite(vitesse_mh);
		}
		else if (val.equalsIgnoreCase("noeud")) {
			cap.chgt_Unite(vitesse_n);
		}
		else if (val.equalsIgnoreCase("beaufort")) {
			cap.chgt_Unite(vitesse_bf);
		}

	}

}
