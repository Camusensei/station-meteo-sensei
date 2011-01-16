package Meteo;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Prog {
	
	public static void main (String[] args) {


		unit_num_coeff Kelvin = new unit_num_coeff
		(null, "K", "temperature en kelvins", "+##0.0#;-##0.0#", 2, 1, 273.15);	
		unit_num_coeff Fahrenheit = new unit_num_coeff
		(null, "F", "temperature en degres fahrenheit", "+##0.0#;-##0.0#", 2, 1.8, 32);
		unit_num Celsius = new unit_num
		(null, "C", "temperature en degres celsius", "+##0.0#;-##0.0#", 2);
			
		Collection<unit> temp = new LinkedList<unit>();
		temp.add(Fahrenheit); temp.add(Kelvin); temp.add(Celsius);
		
			
		Sonde_Random sonde1 = new Sonde_Random (-40, 100, 5, 1000); // delai 1 sec
		
		Thermometre thermo1 = new Thermometre
		(	null, //string formattedvalue
			"C", //string symbol
			"T en degre celsius", //string description
			0.0, //double valeur
			"thermo1", //string ID
			temp, //collection<unit>
			(float) 100, //captMax
			(float) -40, //catpMin
			(float) 90, //plageMax
			(float) -30); //plafgeMin
		
		sonde1.addObserver(thermo1);
	
		
		
		
		String[] beaufString = {"0", "1", "2", "3"};
		double[] beaufDouble = {1,5,11};
		String[] beaufString1 = {"calme plat", "peu de vent", "plus de vent", "encore plus de vent"};
		unit_num Kmh = new unit_num
		(null, "Km/h", "vitesse en km/h", "+##0.0#", 2);
		unit_num_coeff ms = new unit_num_coeff
		(null, "m/s", "vitesse en m/s", "+##0.0#", 2, 10/36, 0);
		unit_string beaufortNum = new unit_string
		(null, "dB", "nombre de beaufort", beaufString, beaufDouble);
		unit_string beaufortString = new unit_string
		(null, "eB", "description de beaufort", beaufString1, beaufDouble);
		
		Collection<unit> vit = new LinkedList<unit>(); //{Fahrenheit, Kelvin};		
		vit.add(Kmh); vit.add(ms); vit.add(beaufortNum);
		
		Sonde_Random sonde2 = new Sonde_Random (0, 20, 1, 1000); // delai 1 sec
		
		Anemometre anemo1 = new Anemometre (
			null, //formattedvalue
			"Km/h", //symbol
			"Vitesse en km/h", //description
			0, //valeur
			"anemo1", //ID
			vit, //collection<unit>
			0, 30, 0, 40);
		
		sonde2.addObserver(anemo1);
		
		sonde2.run();
		anemo1.setValue(sonde2.getValeur());
		
		beaufortString.setFormattedValue(anemo1.get_valeur());
		
		/* Interface graphique */
		
		JFrame station = new JFrame();
		JPanel complet = new JPanel();
		
        station.setTitle("Station d'Evry, projet ILO 2011");
        station.setSize(800, 300);
        station.setLocationRelativeTo(null);
        station.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        station.setResizable(false);
        station.setContentPane(complet);
        
        
        GridLayout base = new GridLayout (2,1);
        JPanel rosace = new JPanel();        
        rosace.setPreferredSize(new Dimension(300, 300));
        rosace.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel capteur1 = new JPanel();        
        capteur1.setPreferredSize(new Dimension(500, 100));
        capteur1.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel capteur2 = new JPanel();        
        capteur2.setPreferredSize(new Dimension(500, 100));
        capteur2.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        JPanel capteur3 = new JPanel();        
        capteur3.setPreferredSize(new Dimension(500, 100));
        capteur3.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
  //      rosace.drawOval(75, 75, 150, 150);
        
        complet.add(rosace, BorderLayout.WEST);
        capteur1.add(new JLabel("0"));
        complet.add(capteur1, BorderLayout.EAST);
        complet.add(capteur2, BorderLayout.EAST);
        complet.add(capteur3, BorderLayout.EAST);

		station.setVisible(true);
		
		
		/* FIn interface graphique*/
		
		/*sonde1.run();
		//sonde1.getValeur();
		thermo1.setValue(sonde1.getValeur());
		
		thermo1.conversion(Celsius);
		
		thermo1.get_valeur();
		*/
		
		
		
	
	}

}
