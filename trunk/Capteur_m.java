package Meteo;

import java.util.Observable;

public abstract class Capteur_m extends Capteur_base implements
		I_capteur_memory {

	public Capteur_m(Observable obs){
		super(obs);
	}
	
	/**
	 * @uml.property name="mem_max"
	 */
	private float mem_max = 0;

	/**
	 * @uml.property name="mem_min"
	 */
	private float mem_min = 0;

	@Override
	public float getMem_min() {
		return mem_min;
	}

	@Override
	public void setMem_min(float mem_min) {
		this.mem_min = mem_min;

	}

	@Override
	public float getMem_max() {
		return mem_max;
	}

	@Override
	public void setMem_max(float mem_max) {
		this.mem_max = mem_max;
	}

	/**
		 */
	public void update(Observable obs, Object arg1) {
	super.update(obs, arg1);
	}

}
