package Meteo;

import java.util.Observable;
import java.util.Observer;
import java.util.Collection;

/**
 * @uml.dependency   supplier="Meteo.unit"
 */
public abstract class Capteur_base implements Observer {


	public Capteur_base (Observable obs){
		valeur=0;
		observable=obs;
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
	protected Object valeur;
	@Override
	public void update(Observable obs, Object arg1) {
		if (obs!=observable){return;}
		valeur=arg1;
		//Collection<unit> test=null;
		//Observable test2=null;
		//if (unités!=test) return;
		//if (observable!=test2) return;
		
	}

	/** 
	 * @uml.property name="observable"
	 * @uml.associationEnd aggregation="shared" inverse="capteur_base:java.util.Observable"
	 */



}
