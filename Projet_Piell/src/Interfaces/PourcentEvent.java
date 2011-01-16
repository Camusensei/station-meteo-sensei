package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Capteur.Capteur_prevision;

public class PourcentEvent implements ActionListener {

	private Capteur_prevision cap;

	public PourcentEvent(Capteur_prevision cap) {
	    this.cap = cap;
	  }

	@Override
	public void actionPerformed(ActionEvent event) { 
		//appel de la fonction qui remet � zero la tendance de la temperature
		cap.reset_tendance();
	}

}
