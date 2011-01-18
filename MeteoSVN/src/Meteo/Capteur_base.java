package Meteo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * La classe Capteur_base.
 */
/*
 * @uml.dependency   supplier="Meteo.unit"
 */
public abstract class Capteur_base implements Observer {

	/** Liste des capteurs. */
	public static ArrayList<Capteur_base> capteurs=new ArrayList<Capteur_base>();
	
	/**
	 * Instantiates a new capteur_base.
	 *
	 * @param unit�s la liste des unit�s associ�es
	 * @param name le nom du capteur
	 * @param observable l'observable associ�
	 * @throws Exception l'�ventuelle exception
	 */
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

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return("nom="+this.name+" unit�s="+this.unit�s+" valeur="+this.valeur);
	}
	
	/**
	 * Count_observers.
	 *
	 * @return le nombre d'observeurs existants
	 */
	public static int count_observers(){
		return capteurs.size();
	};
	
	/**
	 * Del_observer. Supprime l'observeur actuel de la liste des observeurs.
	 */
	public void del_observer (){
		observable.deleteObserver(this);
	}
	
	/** Les unit�s. @uml.property name="unit�s" @uml.associationEnd multiplicity="(1 -1)" aggregation="shared" inverse="capteur_base:Meteo.unit" */
	private List<unit> unit�s;
	
	/**
	 * r�cup�re les unit�s.
	 *
	 * @return la liste des unit�s
	 */
	public Object[] getUnit�s() {
		return ((Object[]) (unit�s.toArray()));
	}

	/** L'unit� actuellement utilis�e. */
	private unit unit_chosen;
	
	/** La valeur. */
	protected float valeur;
	
	/**
	 * R�cup�re l'unit� en cours.
	 *
	 * @return l'unit� en cours
	 */
	public unit getUnit_chosen() {
		return unit_chosen;
	}

	/**
	 * R�cup�re la valeur.
	 *
	 * @return la valeur
	 * @throws Exception l'�ventuelle exception
	 */
	public String getValeur() throws Exception {
		return unit_chosen.getFormattedValue(valeur);
	}

	/**
	 * d�finie l'unit� utilis�e.
	 *
	 * @param unit_chosen la nouvelle unit�
	 */
	public void setUnit_chosen(unit unit_chosen) {
		this.unit_chosen = unit_chosen;
	}

	/** Le nom. */
	public String name;
	
	/** The observable. @uml.property name="observable" @uml.associationEnd aggregation="shared" inverse="capteur_base:java.util.Observable" */
	private Observable observable;
	
	/**
	 * R�cup�re l'observable.
	 *
	 * @return l'observable
	 */
	public Observable getObservable() {
		return observable;
	}

	/**
	 * Impl�mentation de l'update des observables
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object arg1) {
		if (obs!=observable) return;
		valeur=(Float)arg1;
	}

	/**
	 * Renvoie la valeur sous forme de String.
	 *
	 * @return la valeur formatt�e en String
	 * @throws Exception l'�ventuelle exception
	 */
	public String current_value() throws Exception {
		return unit_chosen.getFormattedValue(valeur);
	};
}
