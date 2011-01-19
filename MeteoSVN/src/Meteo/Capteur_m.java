package Meteo;

import java.util.List;
import java.util.Observable;


/**
 * La classe Capteur_m implémente les capteurs avec mémoire.
 */
public abstract class Capteur_m extends Capteur_base implements
		I_capteur_memory {

	/**
	 * Instantiates a new capteur_m.
	 *
	 * @param unités la liste d'unités associées au capteur
	 * @param name le nom du capteur
	 * @param observable l'observable associé
	 * @throws Exception l'éventuelle exception
	 */
	public Capteur_m(List<unit> unités, String name, Observable observable)
			throws Exception {
		super(unités, name, observable);
		this.mem_max = 0F;
		this.mem_min = 0F;
		this.set = false;
	}

	/**
	 * @see Meteo.Capteur_base#toString()
	 */
	@Override
	public String toString() {
		return (super.toString() + " min=" + this.mem_min + " max=" + this.mem_max);
	}

	/** The mem_max. @uml.property name="mem_max" */
	private float mem_max;

	/** The mem_min. @uml.property name="mem_min" */
	private float mem_min;

	/** prêt. */
	protected boolean set;

	/**
	 * getter de mem_min
	 * @see Meteo.I_capteur_memory#getMem_min()
	 */
	@Override
	public float getMem_min() {
		return mem_min;
	}

	/**
	 * setter de mem_min
	 * @see Meteo.I_capteur_memory#setMem_min(float)
	 */
	@Override
	public void setMem_min(float mem_min) {
		this.mem_min = mem_min;

	}

	/**
	 * getter de mem_max
	 * @see Meteo.I_capteur_memory#getMem_max()
	 */
	@Override
	public float getMem_max() {
		return mem_max;
	}

	/**
	 * setter de mem_max
	 * @see Meteo.I_capteur_memory#setMem_max(float)
	 */
	@Override
	public void setMem_max(float mem_max) {
		this.mem_max = mem_max;
	}

	/**
	 * Implémentation de l'update des observables
	 * @see Meteo.Capteur_base#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		if (set == false) {
			mem_max = valeur;
			mem_min = valeur;
			set = true;
		}
		if (valeur > mem_max) {
			mem_max = valeur;
		}
		if (valeur < mem_min) {
			mem_min = valeur;
		}
	}

	/**
	 * Reset de la mémoire du capteur.
	 */
	public void reset() {
		mem_min = valeur;
		mem_max = valeur;
	}

}
