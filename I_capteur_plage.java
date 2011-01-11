package Meteo;


public interface I_capteur_plage {

	/**
	 * @return  Returns the plage_min.
	 * @uml.property  name="plage_min" readOnly="true"
	 */
	public float getPlage_min();

	/**
	 * @return  Returns the plage_max.
	 * @uml.property  name="plage_max"
	 */
	public float getPlage_max();
}
