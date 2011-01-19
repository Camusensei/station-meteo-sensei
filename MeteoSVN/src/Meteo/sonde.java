package Meteo;

import java.util.Observable;

/**
 * @uml.dependency supplier="Meteo.Float_object"
 */
public abstract class sonde extends Observable implements Runnable {

	private long milisecondes;

	/**
	 * @param time_ms le temps en milisecondes d'attente entre deux nouvelles valeurs
	 */
	public sonde(long time_ms) {
		super();
		milisecondes = time_ms;
	}

	/**
	 * Notifie les Capteurs que la sonde a une nouvelle valeur
	 * @param new_value la nouvelle valeur à communiquer
	 */
	public void change(float new_value) {
		super.setChanged();
		super.notifyObservers(new_value);
	}

	/**
	 * Calcul de la nouvelle valeur et envoi aux capteurs
	 */
	public void setData() {
		return;
	}

	/**
	 * Effectue un calcul de valeur toutes les milisecondes demandées
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public synchronized void run() {
		while (true) {
			this.setData();
			try {
				wait(milisecondes);
			} catch (InterruptedException e) {
				System.out
						.println("La sonde a reçu une requête d'interruption !");
				e.printStackTrace();
				break;
			}
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		}
	}

}
