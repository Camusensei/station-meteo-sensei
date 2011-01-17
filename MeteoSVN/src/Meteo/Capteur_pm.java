package Meteo;

import java.util.List;
import java.util.Observable;

public abstract class Capteur_pm extends Capteur_m implements I_capteur_plage {

	public boolean d�passe_min() {
		return d�passement_min;
	}

	public boolean d�passe_max() {
		return d�passement_max;
	}
	
	@Override
	public String toString(){
		return(super.toString()+" plageMin="+this.plage_min+" d�passement-="+this.d�passement_min+" plageMax="+this.plage_max+" d�passement+="+this.d�passement_max);
	}

	public Capteur_pm(List<unit> unit�s, String name, 
			Observable observable, float mem_max, float mem_min,
			float plage_min, float plage_max) throws Exception {
		super(unit�s, name, observable, mem_max, mem_min);
		this.plage_min = plage_min;
		this.d�passement_min = false;
		this.plage_max = plage_max;
		this.d�passement_max = false;
		set=false;
	}
	@Override
	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		if (valeur>plage_max){
			d�passement_max=true;
			valeur=plage_max;
		}
		else {
			d�passement_max=false;
		}
		if (valeur<plage_min){
			d�passement_min=true;
			valeur=plage_min;
		}
		else {
			d�passement_min=false;
		}
	}

	/**
	 * @uml.property name="plage_min"
	 */
	private float plage_min;

	private boolean d�passement_min;
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
	
	private boolean d�passement_max;

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
