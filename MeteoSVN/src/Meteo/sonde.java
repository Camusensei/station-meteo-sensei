package Meteo;

import java.util.Observable;

/**
 * @uml.dependency   supplier="Meteo.Float_object"
 */
public abstract class sonde extends Observable implements Runnable {

	private long milisecondes;
	public sonde (long time_ms){
		super();
		milisecondes=time_ms;
	}
	
	public void change(float new_value){
		super.setChanged();
		super.notifyObservers(new_value);
	}
	public void setData(){
		return;
	}
	@Override
	public synchronized void run() {
		while(true){
			this.setData();
			try {
				wait(milisecondes);
			} catch (InterruptedException e) {
				System.out.println("La sonde a reçu une requête d'interruption !");
				e.printStackTrace();
				break;
			}
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		}
	}
	
}
