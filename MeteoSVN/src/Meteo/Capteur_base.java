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
	 * @param unités la liste des unités associées
	 * @param name le nom du capteur
	 * @param observable l'observable associé
	 * @throws Exception l'éventuelle exception
	 */
	public Capteur_base(List<unit> unités, String name, Observable observable) throws Exception {
		super();
		this.unités = unités;
		if (unités.isEmpty()) throw new Exception("Capteur de base : Liste d'unités vide !");
		this.unit_chosen = unités.get(0);
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
		return("nom="+this.name+" unités="+this.unités+" valeur="+this.valeur);
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
	
	/** Les unités. @uml.property name="unités" @uml.associationEnd multiplicity="(1 -1)" aggregation="shared" inverse="capteur_base:Meteo.unit" */
	private List<unit> unités;
	
	/**
	 * récupère les unités.
	 *
	 * @return la liste des unités
	 */
	public Object[] getUnités() {
		return ((Object[]) (unités.toArray()));
	}

	/** L'unité actuellement utilisée. */
	private unit unit_chosen;
	
	/** La valeur. */
	protected float valeur;
	
	/**
	 * Récupère l'unité en cours.
	 *
	 * @return l'unité en cours
	 */
	public unit getUnit_chosen() {
		return unit_chosen;
	}

	/**
	 * Récupère la valeur.
	 *
	 * @return la valeur
	 * @throws Exception l'éventuelle exception
	 */
	public String getValeur() throws Exception {
		return unit_chosen.getFormattedValue(valeur);
	}

	/**
	 * définie l'unité utilisée.
	 *
	 * @param unit_chosen la nouvelle unité
	 */
	public void setUnit_chosen(unit unit_chosen) {
		this.unit_chosen = unit_chosen;
	}

	/** Le nom. */
	public String name;
	
	/** The observable. @uml.property name="observable" @uml.associationEnd aggregation="shared" inverse="capteur_base:java.util.Observable" */
	private Observable observable;
	
	/**
	 * Récupère l'observable.
	 *
	 * @return l'observable
	 */
	public Observable getObservable() {
		return observable;
	}

	/**
	 * Implémentation de l'update des observables
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
	 * @return la valeur formattée en String
	 * @throws Exception l'éventuelle exception
	 */
	public String current_value() throws Exception {
		return unit_chosen.getFormattedValue(valeur);
	};
}
