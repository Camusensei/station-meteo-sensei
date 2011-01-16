package Interfaces;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Capteur.Capteur_minmax;

public class MinMaxPanel extends JPanel {

	public void misaniveau (double minimum, double maximum) {
		// Afficher pourcentage et le mettre � jour au fur et � mesure
		JLabel min_name = new JLabel("Min : ");
		JLabel max_name = new JLabel("Max : ");
		JLabel min_val = new JLabel(Double.toString(minimum));
		JLabel max_val = new JLabel(Double.toString(maximum));
		
		//On enlève tous les éléments sauf le bouton et on met les nouvelle valeurs à la place
		((Container) getComponent(0)).removeAll();
		((Container) getComponent(0)).add(min_name);
		((Container) getComponent(0)).add(min_val);
		((Container) getComponent(1)).removeAll();
		((Container) getComponent(1)).add(max_name);
		((Container) getComponent(1)).add(max_val);
		updateUI();
	}

	
	public MinMaxPanel(double minimum, double maximum, Capteur_minmax cap) {
		setLayout(new GridLayout(0, 1));
		
		JPanel min = new JPanel();
		min.setLayout(new GridLayout(1, 0));
		JLabel min_name = new JLabel("Min : ");
		JLabel min_val = new JLabel(Double.toString(minimum));
		min.add(min_name);
		min.add(min_val);
		
		JPanel max = new JPanel();
		max.setLayout(new GridLayout(1, 0));
		JLabel max_name = new JLabel("Max : ");
		JLabel max_val = new JLabel(Double.toString(maximum));
		max.add(max_name);
		max.add(max_val);
		
		JButton reset_mm = new JButton("Reset");
		reset_mm.addActionListener(new MinmaxEvent(cap));
		
		add(min);
		add(max);
		add(reset_mm);
	}
}
