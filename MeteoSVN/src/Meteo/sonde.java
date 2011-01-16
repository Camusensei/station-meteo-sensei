package Meteo;

import java.util.Observable;

/**
 * @uml.dependency   supplier="Meteo.Float_object"
 */
public class sonde extends Observable implements Runnable {

	public sonde (){
		super();
	}
	
	protected Observable obs;
	public void change(float new_value){
		super.setChanged();
		super.notifyObservers(new Float_object(new_value));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
}
