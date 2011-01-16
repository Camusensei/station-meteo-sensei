package Interfaces;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Capteur.Capteur_prevision;

public class TendancePanel extends JPanel {
	
	public void misaniveau (double tend) {
		PanelImage fleche;
		if(tend==0)
			fleche = new PanelImage("images/Fleche_droite.gif");
		else if(tend>0)
			fleche = new PanelImage("images/Fleche_haut_droite.gif");
		else
			fleche = new PanelImage("images/Fleche_bas_droite.gif");
		// Afficher pourcentage et le mettre � jour au fur et � mesure
		JLabel textepour = new JLabel(Double.toString(tend).concat(" %"));
		
		//On enlève tous les éléments sauf le bouton et on met les nouvelle valeurs à la place
		((Container) getComponent(0)).removeAll();
		((Container) getComponent(0)).add(fleche);
		((Container) getComponent(0)).add(textepour);
		//add(reset_pour);
		//repaint();
		updateUI();
	}

	
	public TendancePanel (double tend, Capteur_prevision cap) {
		//On instancie le JPanel verticalement
		setLayout(new GridLayout(0, 1));
		//On génère un second JPanel horizontale pour la flèche et le pourcentage
		JPanel tendance_sans_reset = new JPanel();
		tendance_sans_reset.setLayout(new GridLayout(1, 0));
		
		// afficher une fleche selon la tendance
		// r�cup�ration de la tendance : float tend = ?? ;
		PanelImage fleche;
		if(tend==0)
			fleche = new PanelImage("images/Fleche_droite.gif",42,42);
		else if(tend>0)
			fleche = new PanelImage("images/Fleche_haut_droite.gif",42,42);
		else
			fleche = new PanelImage("images/Fleche_bas_droite.gif",42,42);
		tendance_sans_reset.add(fleche);
		// Afficher pourcentage et le mettre � jour au fur et � mesure
		// Float.toString(tend);
		JLabel textepour = new JLabel(Double.toString(tend).concat(" %"));
		tendance_sans_reset.add(textepour);
		
		
		JButton reset_pour = new JButton("Reset");
		reset_pour.addActionListener(new PourcentEvent(cap));
		
		
		add(tendance_sans_reset);
		add(reset_pour);
	}
}
