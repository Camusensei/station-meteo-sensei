package Meteo;

import java.util.Observable;
import java.util.Observer;
import java.util.Collection;

/**
 * @uml.dependency   supplier="Meteo.unit"
 */
public abstract class Capteur_base implements Observer {


	public Capteur_base (Observable obs,String name){
		valeur=0;
		observable=obs;
		nom=name;
		// TODO unités
		obs.addObserver(this);
	}
	
	public void del_observer (){
		observable.deleteObserver(this);
	}
	
	/** 
	 * @uml.property name="unités"
	 * @uml.associationEnd multiplicity="(1 -1)" aggregation="shared" inverse="capteur_base:Meteo.unit"
	 */
	private Collection<unit> unités;
	private Observable observable;
	protected float valeur;
	public String nom;
	private Object getvalue;
	@Override
	public void update(Observable obs, Object arg1) {
		if (obs!=observable){return;}
		// delete following lines
		getvalue=arg1;
		arg1=getvalue;
		Collection<unit> test=null;
		Observable test2=null;
		if (unités!=test) return;
		if (observable!=test2) return;
		
	};



}
