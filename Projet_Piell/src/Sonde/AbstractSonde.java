package Sonde;

import java.util.Observable;

import Capteur.AbstractCapteur;

public abstract class AbstractSonde extends Observable {

	/*
	 * private AbstractCapteur[] abstractCapteurs;
	 * 
	 * 
	 * public AbstractCapteur[] getAbstractCapteur() { return abstractCapteurs;
	 * }
	 * 
	 * public void setAbstractCapteur(AbstractCapteur[] abstractCapteur) {
	 * abstractCapteurs = abstractCapteur; }
	 */

	/**
		 */
	public void registerCapteur(AbstractCapteur obs) {
	}

	/**
			 */
	public void unregisterCapteur(AbstractCapteur obs) {
	}

	/**
	 * @uml.property name="valeur"
	 */
	private double valeur;

	/**
	 * Getter of the property <tt>valeur</tt>
	 * 
	 * @return Returns the valeur.
	 * @uml.property name="valeur"
	 */
	public double getValeur() {
		return valeur;
	}

	/**
	 * Setter of the property <tt>valeur</tt>
	 * 
	 * @param val
	 *            The valeur to set.
	 * @uml.property name="valeur"
	 */
	public void setValeur(double val) {
		this.valeur = val;
	}

}
