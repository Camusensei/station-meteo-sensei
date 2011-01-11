package Meteo;

import java.util.Observable;

public abstract class Capteur_m extends Capteur_base implements
		I_capteur_memory {

	public Capteur_m(Observable obs) {
		super(obs);
		mem_max=0;
		mem_min=0;
		set=false;
	}

	/**
	 * @uml.property name="mem_max"
	 */
	private float mem_max;

	/**
	 * @uml.property name="mem_min"
	 */
	private float mem_min;
	
	private boolean set;

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
		if (set==false){
			mem_max=valeur;
			mem_min=valeur;
			set=true;
		}
		if (valeur > mem_max) {
			mem_max = valeur;
		}
		if (valeur < mem_min) {
			mem_min = valeur;
		}
	}

	public void reset() {
		mem_min=valeur;
		mem_max=valeur;
	}

}
