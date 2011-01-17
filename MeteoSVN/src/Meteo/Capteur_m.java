package Meteo;

import java.util.List;
import java.util.Observable;

public abstract class Capteur_m extends Capteur_base implements
		I_capteur_memory {

	public Capteur_m(List<unit> unités, String name, Observable observable)
			throws Exception {
		super(unités, name, observable);
		this.mem_max = 0F;
		this.mem_min = 0F;
		this.set = false;
	}

	@Override
	public String toString() {
		return (super.toString() + " min=" + this.mem_min + " max=" + this.mem_max);
	}

	/**
	 * @uml.property name="mem_max"
	 */
	private float mem_max;

	/**
	 * @uml.property name="mem_min"
	 */
	private float mem_min;

	protected boolean set;

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

	public void reset() {
		mem_min = valeur;
		mem_max = valeur;
	}

}
