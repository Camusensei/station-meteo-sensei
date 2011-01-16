package Interfaces;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Capteur.Station;

public class Affichage extends JFrame {
	private Station station;
	
	public Affichage(Station station) {
		super();
		this.station = station;

		buildContentPane();// On initialise notre fenï¿½tre
	}

	private void buildContentPane() {
		// Provide minimum sizes for the two components in the split pane
		/*
		 * Dimension minimumSize = new Dimension(200, 200);
		 * rosace.setMinimumSize(minimumSize);
		 * gridPane.setMinimumSize(minimumSize);
		 */

		JPanel gridPane = new JPanel();
		gridPane.setLayout(new GridLayout(0, 1));

		// AFFICHAGE TEMPERATURE
		JPanel tempe = new JPanel();
		tempe.setLayout(new GridLayout(1, 0));

		// affichage du descriptif
		JLabel descr_temp = new JLabel("TempÃ©rature");
		
		// affichage de la valeur de la tempï¿½rature
		Double mem_temp = station.getTemperature().getValeur_base();
		JLabel texte1 = new JLabel(station.getTemperature().getValeur());
		// mise ï¿½ jour du texte
		JPanel val_temp = new JPanel();
		val_temp.setLayout(new BorderLayout());
		val_temp.add(texte1, BorderLayout.LINE_END);

		Choice choix_temp = new Choice();
		choix_temp.addItem("°C");
		choix_temp.addItem("°F");
		choix_temp.addItem("K");
		choix_temp.select("°C");
		choix_temp.addItemListener(new Choice_Listener(station.getTemperature()));
		/*
						 * JPanel liste = new JPanel(); liste.setLayout(new
						 * BorderLayout()); liste.add(c,BorderLayout.NORTH);
						 */// test pour la liste dï¿½roulante
		// avec listener pour renvoyer l'unitï¿½ selectionnï¿½e ï¿½ Observer
		

		// Afficher la tendance : fleche, pourcentage, reset
		double mem_tend_temp = station.getTemperature().tendance();
		TendancePanel tendance_temp = new TendancePanel(mem_tend_temp,station.getTemperature());
		// Afficher min et max
		MinMaxPanel minmax_temp = new MinMaxPanel(station.getTemperature().getMinimum(),station.getTemperature().getMaximum(),station.getTemperature());
		
		//On ajoute tous les Ã©lÃ©ments de la ligne
		tempe.add(descr_temp);
		tempe.add(val_temp);
		tempe.add(choix_temp);
		tempe.add(tendance_temp);
		tempe.add(minmax_temp);

		// AFFICHAGE PRESSION
		JPanel press = new JPanel();
		press.setLayout(new GridLayout(1, 0));

		// affichage du descriptif
		JLabel descr_pression = new JLabel("Pression");
		
		// affichage de la valeur de la tempï¿½rature
		JLabel texte2 = new JLabel("val pression");
		// mise ï¿½ jour du texte
		JPanel val_pression = new JPanel();
		val_pression.setLayout(new BorderLayout());
		val_pression.add(texte2, BorderLayout.LINE_END);
		// si la valeur a dï¿½passï¿½ une des limites : boolean dep2 = ??;
		// if(dep2==true)
		// then provi2.setBackground(Color.red);
		

		Choice choix_pression = new Choice();
		choix_pression.addItem("hPa");
		choix_pression.addItem("mBar");
		choix_pression.addItem("mmHg");
		choix_pression.addItem("poHg");
		choix_pression.select("hPa");
		choix_pression.addItemListener(new Choice_Listener(station.getPression()));
		// avec listener pour renvoyer l'unitï¿½ selectionnï¿½e ï¿½ Observer
		
		// Afficher la tendance : fleche, pourcentage, reset
		double mem_tend_pression = station.getPression().tendance();
		TendancePanel tendance_pression = new TendancePanel(mem_tend_pression,station.getPression());
		/*tendance2.setLayout(new GridLayout(0, 1));
		// afficher une fleche selon la tendance
		// rï¿½cupï¿½ration de la tendance : float tend2 = ?? ;
		// if(tend2==0)
		// PanelImage fleche2 = new PanelImage("images/Fleche_droite.gif");
		// else if(tend2>0)
		// PanelImage fleche2 = new PanelImage("images/Fleche_haut_droite.gif");
		// else
		PanelImage fleche2 = new PanelImage("images/Fleche_bas_droite.gif");
		tendance2.add(fleche2);
		// Afficher pourcentage et le mettre ï¿½ jour au fur et ï¿½ mesure
		// Float.toString(tend2);
		JLabel textepour2 = new JLabel("pourcentage");
		tendance2.add(textepour2);
		JButton reset_pour2 = new JButton("Reset");
		reset_pour2.addActionListener(new PressionEvent("pour"));
		tendance2.add(reset_pour2);*/

		// Afficher min et max
		MinMaxPanel minmax_pression = new MinMaxPanel(station.getPression().getMinimum(),station.getPression().getMaximum(),station.getPression());
		
		press.add(descr_pression);
		press.add(val_pression);
		press.add(choix_pression);
		press.add(tendance_pression);
		press.add(minmax_pression);

		// AFFICHAGE VITESSE DU VENT
		JPanel vent = new JPanel();
		vent.setLayout(new GridLayout(1, 0));

		// affichage du descriptif
		JLabel descr_vvent = new JLabel("Vitesse vent");
		
		// affichage de la valeur de la tempï¿½rature
		JLabel texte3 = new JLabel("val vite");
		// mise ï¿½ jour du texte
		JPanel val_vvent = new JPanel();
		val_vvent.setLayout(new BorderLayout());
		val_vvent.add(texte3, BorderLayout.LINE_END);
		// si la valeur a dï¿½passï¿½ une des limites : boolean dep = ??;
		// if(dep==true)
		// then provi.setBackground(Color.red);

		Choice choix_vvent = new Choice();
		choix_vvent.addItem("km/h");
		choix_vvent.addItem("m/s");
		choix_vvent.addItem("M/h");
		choix_vvent.addItem("noeud");
		choix_vvent.addItem("beaufort");
		choix_vvent.select("km/h");
		choix_vvent.addItemListener(new Choice_Listener(station.getVitesse()));
		/*
						 * JPanel liste = new JPanel(); liste.setLayout(new
						 * BorderLayout()); liste.add(c,BorderLayout.NORTH);
						 */
		// avec listener pour renvoyer l'unitï¿½ selectionnï¿½e ï¿½ Observer
		JPanel complement = new JPanel();
		JPanel complement2 = new JPanel();
		
		vent.add(descr_vvent);
		vent.add(val_vvent);
		vent.add(choix_vvent);
		vent.add(complement);
		vent.add(complement2);

		// AFFICHAGE DIRECTION DU VENT
		JPanel sens = new JPanel();
		sens.setLayout(new GridLayout(1, 0));

		// affichage du descriptif
		JLabel descr_dvent = new JLabel("Direction vent");
		
		// affichage de la valeur de la tempï¿½rature
		JLabel texte4 = new JLabel("val dir");
		// mise ï¿½ jour du texte
		JPanel val_dvent = new JPanel();
		val_dvent.setLayout(new BorderLayout());
		val_dvent.add(texte4, BorderLayout.LINE_END);
		// si la valeur a dï¿½passï¿½ une des limites : boolean dep4 = ??;
		// if(dep4==true)
		// then provi4.setBackground(Color.red);
		

		Choice choix_dvent = new Choice();
		choix_dvent.addItem("rad");
		choix_dvent.addItem("°");
		choix_dvent.addItem("Pts card");
		choix_dvent.select("rad");
		choix_dvent.addItemListener(new Choice_Listener(station.getSensvent()));
		/*
						 * JPanel liste = new JPanel(); liste.setLayout(new
						 * BorderLayout()); liste.add(c,BorderLayout.NORTH);
						 */
		// avec listener pour renvoyer l'unitï¿½ selectionnï¿½e ï¿½ Observer
		
		JPanel vide11 = new JPanel();
		JPanel vide21 = new JPanel();
		
		sens.add(descr_dvent);
		sens.add(val_dvent);
		sens.add(choix_dvent);
		sens.add(vide11);
		sens.add(vide21);

		// AFFICHAGE HUMIDITE
		JPanel humi = new JPanel();
		humi.setLayout(new GridLayout(1, 0));

		// affichage du descriptif
		JLabel descr_hum = new JLabel("Humidité");
		
		// affichage de la valeur de la tempï¿½rature
		JLabel texte5 = new JLabel("val");
		// mise ï¿½ jour du texte
		JPanel val_hum = new JPanel();
		val_hum.setLayout(new BorderLayout());
		val_hum.add(texte5, BorderLayout.LINE_END);
		// si la valeur a dï¿½passï¿½ une des limites : boolean dep4 = ??;
		// if(dep4==true)
		// then provi4.setBackground(Color.red);
		

		JLabel pour_int = new JLabel(" %");
		JPanel pour = new JPanel();
		pour.setLayout(new BorderLayout());
		pour.add(pour_int, BorderLayout.LINE_START);
		

		JPanel vide12 = new JPanel();
		JPanel vide22 = new JPanel();
		
		humi.add(descr_hum);
		humi.add(val_hum);
		humi.add(pour);
		humi.add(vide12);
		humi.add(vide22);

		gridPane.add(tempe);
		gridPane.add(press);
		gridPane.add(vent);
		gridPane.add(sens);
		gridPane.add(humi);

		PanelImage rosace = new PanelImage("images/rose.png",station.getSensvent().getValeur_base());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				rosace, gridPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(289);
		splitPane.setResizeWeight(0.0);

		JFrame fenetre = new JFrame();

		add(splitPane);
		setTitle("Station météo"); // On donne un titre ï¿½ l'application
		// pack();
		setSize(870, 320);// Dimension au demarrage
		Dimension dimension = new Dimension(830, 320);
		setMinimumSize(dimension); // Dimenion minimum de la fenetre
		setLocationRelativeTo(null); // On centre la fenï¿½tre sur l'ï¿½cran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Fin du run");
			}

			Date actuelle = new Date();
			DateFormat dateFormat = new SimpleDateFormat(
					"dd/MM/yyyy hh:mm:ss");
			String dat = dateFormat.format(actuelle);
			
			JLabel temporaire;
			
			//mise Ã  jour de la tempÃ©rature
			if (station.getTemperature().tendance()!=mem_tend_temp) {
				tendance_temp.misaniveau(station.getTemperature().tendance());
				mem_tend_temp = station.getTemperature().tendance();
			}
			if (station.getTemperature().getValeur_base()!=mem_temp) {
				val_temp.removeAll();
				temporaire = new JLabel(station.getTemperature().getValeur());
				val_temp.add(temporaire, BorderLayout.LINE_END);
				mem_temp=station.getTemperature().getValeur_base();
				val_temp.updateUI();
			}
			minmax_temp.misaniveau(station.getTemperature().getMinimum(),station.getTemperature().getMaximum());
			
			if (station.getTemperature().isDepassement()) {
				descr_temp.setBackground(Color.red);
			}
			/*
			tempe.add(descr_temp);
			tempe.add(val_temp);
			tempe.add(choix_temp);
			tempe.add(tendance_temp);
			tempe.add(minmax_temp);
			*/
			//mise Ã  jour de la pression			
			if (station.getPression().tendance()!=mem_tend_pression) {
				tendance_pression.misaniveau(station.getPression().tendance());
				mem_tend_pression = station.getPression().tendance();
			}
			val_pression.removeAll();
			temporaire = new JLabel(station.getPression().getValeur());
			val_pression.add(temporaire, BorderLayout.LINE_END);
			val_pression.updateUI();
			
			minmax_pression.misaniveau(station.getPression().getMinimum(),station.getPression().getMaximum());
			
			if (station.getPression().isDepassement()) {
				descr_pression.setBackground(Color.red);
			}
			
			val_vvent.removeAll();
			temporaire = new JLabel(station.getVitesse().getValeur());
			val_vvent.add(temporaire, BorderLayout.LINE_END);
			val_vvent.updateUI();
			
			val_dvent.removeAll();
			temporaire = new JLabel(station.getSensvent().getValeur());
			val_dvent.add(temporaire, BorderLayout.LINE_END);
			val_dvent.updateUI();
			//rosace.drawfleche(station.getSensvent().getValeur_base());
			rosace.setRadian(station.getSensvent().getValeur_base());
			rosace.updateUI();
			
			val_hum.removeAll();
			temporaire = new JLabel(station.getHumidite().getValeur());
			val_hum.add(temporaire, BorderLayout.LINE_END);
			val_hum.updateUI();
			
			
		}
		
	}
	
}
