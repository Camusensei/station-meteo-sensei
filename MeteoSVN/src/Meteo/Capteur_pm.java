package Meteo;

import java.util.Observable;

public abstract class Capteur_pm extends Capteur_m implements I_capteur_plage {

	public Capteur_pm(Observable obs) {
		super(obs);
		plage_min = 0;
		dépassement_max=false;
		plage_max = 0;
		dépassement_min=false;
		set = false;
	}

	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		if (valeur>plage_max){
			dépassement_max=true;
			valeur=plage_max;
		}
		else {
			dépassement_max=false;
		}
		if (valeur<plage_min){
			dépassement_min=true;
			valeur=plage_min;
		}
		else {
			dépassement_min=false;
		}
	}

	/**
	 * @uml.property name="plage_min"
	 */
	private float plage_min = 0;

	private boolean dépassement_min=false;
	/**
	 * Getter of the property <tt>plage_min</tt>
	 * 
	 * @return Returns the plage_min.
	 * @uml.property name="plage_min"
	 */
	public float getPlage_min() {
		return plage_min;
	}

	/**
	 * Setter of the property <tt>plage_min</tt>
	 * 
	 * @param plage_min
	 *            The plage_min to set.
	 * @uml.property name="plage_min"
	 */
	public void setPlage_min(float plage_min) {
		this.plage_min = plage_min;
	}

	/**
	 * @uml.property name="plage_max"
	 */
	private float plage_max = 0;
	
	private boolean dépassement_max;

	/**
	 * Getter of the property <tt>plage_max</tt>
	 * 
	 * @return Returns the plage_max.
	 * @uml.property name="plage_max"
	 */
	public float getPlage_max() {
		return plage_max;
	}

	/**
	 * Setter of the property <tt>plage_max</tt>
	 * 
	 * @param plage_max
	 *            The plage_max to set.
	 * @uml.property name="plage_max"
	 */
	public void setPlage_max(float plage_max) {
		this.plage_max = plage_max;
	}
}
