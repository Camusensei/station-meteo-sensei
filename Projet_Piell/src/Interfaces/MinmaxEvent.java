package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Capteur.Capteur_minmax;

public class MinmaxEvent implements ActionListener {

	private Capteur_minmax cap;

	public MinmaxEvent(Capteur_minmax cap) {
	    this.cap = cap;
	  }

	@Override
	public void actionPerformed(ActionEvent event) { 
		//appel de la fonction qui remet � zero la tendance de la temperature
		cap.reset_minmax();
	}

}
