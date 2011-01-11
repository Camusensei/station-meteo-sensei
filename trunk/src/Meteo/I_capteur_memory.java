package Meteo;


public interface I_capteur_memory {

	/**
	 * @return  Returns the mem_min.
	 * @uml.property  name="mem_min"
	 */
	public float getMem_min();

	/**
	 * Setter of the property <tt>mem_min</tt>
	 * @param mem_min  The mem_min to set.
	 * @uml.property  name="mem_min"
	 */
	public void setMem_min(float mem_min);

	/**
	 * @return  Returns the mem_max.
	 * @uml.property  name="mem_max"
	 */
	public float getMem_max();

	/**
	 * Setter of the property <tt>mem_max</tt>
	 * @param mem_max  The mem_max to set.
	 * @uml.property  name="mem_max"
	 */
	public void setMem_max(float mem_max);

}
