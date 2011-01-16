package Meteo;

public interface I_capteur_Minmax {

	/**
	 * @return Returns the mem_max.
	 * @uml.property name="capteur_min"
	 */
	public float getCapteur_min();

	/**
	 * Setter of the property <tt>mem_max</tt>
	 * 
	 * @param mem_max
	 *            The mem_max to set.
	 * @uml.property name="capteur_min"
	 */
	public void setCapteur_min(float capteur_min);

	/**
	 * @return Returns the mem_min.
	 * @uml.property name="capteur_max"
	 */
	public float getCapteur_max();

	/**
	 * Setter of the property <tt>mem_min</tt>
	 * 
	 * @param mem_min
	 *            The mem_min to set.
	 * @uml.property name="capteur_max"
	 */
	public void setCapteur_max(float capteur_max);

}
