package Meteo;

import java.util.List;
import java.util.Observable;

/**
 * La classe Capteur_pm impl�mente les capteurs avec plage (et descend de ceux � m�moire).
 */
public abstract class Capteur_pm extends Capteur_m implements I_capteur_plage {

	/**
	 * renvoie le bool�en pour le d�passement de la borne inf�rieure
	 *
	 * @return true en cas de d�passement de la borne inf�rieure
	 */
	public boolean d�passe_min() {
		return d�passement_min;
	}

	/**
	 * renvoie le bool�en pour le d�passement de la borne sup�rieure
	 *
	 * @return true en cas de d�passement de la borne sup�rieure
	 */
	public boolean d�passe_max() {
		return d�passement_max;
	}

	/**
	 * @see Meteo.Capteur_m#toString()
	 */
	@Override
	public String toString() {
		return (super.toString() + " plageMin=" + this.plage_min
				+ " d�passement-=" + this.d�passement_min + " plageMax="
				+ this.plage_max + " d�passement+=" + this.d�passement_max);
	}

	/**
	 * Instantiates a new capteur_pm.
	 *
	 * @param unit�s la liste d'unit�s associ�es au capteur
	 * @param name le nom du capteur
	 * @param observable l'observable associ�
	 * @param plage_min la min de la plage
	 * @param plage_max le max de la plage
	 * @throws Exception l'�ventuelle exception
	 */
	public Capteur_pm(List<unit> unit�s, String name, Observable observable,
			float plage_min, float plage_max) throws Exception {
		super(unit�s, name, observable);
		this.plage_min = plage_min;
		this.d�passement_min = false;
		this.plage_max = plage_max;
		this.d�passement_max = false;
		set = false;
	}

	/**
	 * Impl�mentation de l'update des observables
	 * @see Meteo.Capteur_m#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		if (valeur > plage_max) {
			d�passement_max = true;
			valeur = plage_max;
		} else {
			d�passement_max = false;
		}
		if (valeur < plage_min) {
			d�passement_min = true;
			valeur = plage_min;
		} else {
			d�passement_min = false;
		}
	}

	/** Le minimum de la plage. @uml.property name="plage_min" */
	private float plage_min;

	/** Le bool�en de d�passement de la borne inf�rieure. */
	private boolean d�passement_min;

	/**
	 * Getter of the property <tt>plage_min</tt>.
	 *
	 * @return Renvoie la plage_min.
	 */
	/*
	 * @uml.property name="plage_min"
	 */
	public float getPlage_min() {
		return plage_min;
	}

	/** Le maximum de la plage. @uml.property name="plage_max" */
	private float plage_max;

	/** Le bool�en de d�passement de la borne sup�rieure. */
	private boolean d�passement_max;

	/**
	 * Getter of the property <tt>plage_max</tt>.
	 *
	 * @return Returns the plage_max.
	 */
	 /*
	 * @uml.property name="plage_max"
	 */
	public float getPlage_max() {
		return plage_max;
	}

}
