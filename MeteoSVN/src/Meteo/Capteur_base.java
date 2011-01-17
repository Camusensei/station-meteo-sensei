package Meteo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @uml.dependency   supplier="Meteo.unit"
 */
public abstract class Capteur_base implements Observer {

	public static ArrayList<Capteur_base> capteurs=new ArrayList<Capteur_base>();
	
	public Capteur_base(List<unit> unit�s, String name, Observable observable) throws Exception {
		super();
		this.unit�s = unit�s;
		if (unit�s.isEmpty()) throw new Exception("Capteur de base : Liste d'unit�s vide !");
		this.unit_chosen = unit�s.get(0);
		this.valeur = -1F;
		this.name = name;
		this.observable = observable;
		this.observable.addObserver(this);
		capteurs.add(this);
	}

	@Override
	public String toString(){
		return("nom="+this.name+" unit�s="+this.unit�s+" valeur="+this.valeur);
	}
	
	public static int count_observers(){
		return capteurs.size();
	};
	public void del_observer (){
		observable.deleteObserver(this);
	}
	
	/** 
	 * @uml.property name="unit�s"
	 * @uml.associationEnd multiplicity="(1 -1)" aggregation="shared" inverse="capteur_base:Meteo.unit"
	 */
	private List<unit> unit�s;
	public List<unit> getUnit�s() {
		return unit�s;
	}

	private unit unit_chosen;
	protected float valeur;
	public unit getUnit_chosen() {
		return unit_chosen;
	}

	public float getValeur() {
		return valeur;
	}

	public void setUnit_chosen(unit unit_chosen) {
		this.unit_chosen = unit_chosen;
	}

	public String name;
	/** 
	 * @uml.property name="observable"
	 * @uml.associationEnd aggregation="shared" inverse="capteur_base:java.util.Observable"
	 */
	private Observable observable;
	@Override
	public void update(Observable obs, Object arg1) {
		if (obs!=observable) return;
		valeur=(Float)arg1;
	}

	public String current_value() throws Exception {
		return unit_chosen.getFormattedValue(valeur);
	};
}
