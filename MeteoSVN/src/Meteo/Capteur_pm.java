package Meteo;

import java.util.List;
import java.util.Observable;

public abstract class Capteur_pm extends Capteur_m implements I_capteur_plage {

	public boolean dépasse_min() {
		return dépassement_min;
	}

	public boolean dépasse_max() {
		return dépassement_max;
	}
	
	@Override
	public String toString(){
		return(super.toString()+" plageMin="+this.plage_min+" dépassement-="+this.dépassement_min+" plageMax="+this.plage_max+" dépassement+="+this.dépassement_max);
	}

	public Capteur_pm(List<unit> unités, String name, 
			Observable observable, float mem_max, float mem_min,
			float plage_min, float plage_max) throws Exception {
		super(unités, name, observable, mem_max, mem_min);
		this.plage_min = plage_min;
		this.dépassement_min = false;
		this.plage_max = plage_max;
		this.dépassement_max = false;
		set=false;
	}
	@Override
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
	private float plage_min;

	private boolean dépassement_min;
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
	 * @uml.property name="plage_max"
	 */
	private float plage_max;
	
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

}
