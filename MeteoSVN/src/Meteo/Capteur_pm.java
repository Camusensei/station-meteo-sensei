package Meteo;

import java.util.List;
import java.util.Observable;

/**
 * La classe Capteur_pm implémente les capteurs avec plage (et descend de ceux à mémoire).
 */
public abstract class Capteur_pm extends Capteur_m implements I_capteur_plage {

	/**
	 * renvoie le booléen pour le dépassement de la borne infèrieure
	 *
	 * @return true en cas de dépassement de la borne infèrieure
	 */
	public boolean dépasse_min() {
		return dépassement_min;
	}

	/**
	 * renvoie le booléen pour le dépassement de la borne supèrieure
	 *
	 * @return true en cas de dépassement de la borne supèrieure
	 */
	public boolean dépasse_max() {
		return dépassement_max;
	}

	/**
	 * @see Meteo.Capteur_m#toString()
	 */
	@Override
	public String toString() {
		return (super.toString() + " plageMin=" + this.plage_min
				+ " dépassement-=" + this.dépassement_min + " plageMax="
				+ this.plage_max + " dépassement+=" + this.dépassement_max);
	}

	/**
	 * Instantiates a new capteur_pm.
	 *
	 * @param unités la liste d'unités associées au capteur
	 * @param name le nom du capteur
	 * @param observable l'observable associé
	 * @param plage_min la min de la plage
	 * @param plage_max le max de la plage
	 * @throws Exception l'éventuelle exception
	 */
	public Capteur_pm(List<unit> unités, String name, Observable observable,
			float plage_min, float plage_max) throws Exception {
		super(unités, name, observable);
		this.plage_min = plage_min;
		this.dépassement_min = false;
		this.plage_max = plage_max;
		this.dépassement_max = false;
		set = false;
	}

	/**
	 * Implémentation de l'update des observables
	 * @see Meteo.Capteur_m#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		if (valeur > plage_max) {
			dépassement_max = true;
			valeur = plage_max;
		} else {
			dépassement_max = false;
		}
		if (valeur < plage_min) {
			dépassement_min = true;
			valeur = plage_min;
		} else {
			dépassement_min = false;
		}
	}

	/** Le minimum de la plage. @uml.property name="plage_min" */
	private float plage_min;

	/** Le booléen de dépassement de la borne infèrieure. */
	private boolean dépassement_min;

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

	/** Le booléen de dépassement de la borne supèrieure. */
	private boolean dépassement_max;

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
