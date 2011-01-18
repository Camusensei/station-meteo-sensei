package Meteo;

import java.util.List;
import java.util.Observable;

/**
 * La classe Capteur_pmt implémente les capteurs avec tendance (et descend de ceux à mémoire et plage).
 */
public abstract class Capteur_pmt extends Capteur_pm implements I_capteur_trend {

	/** Les 5 dernières valeurs */
	private Float[] last5 = {0F,0F,0F,0F,0F};
	
	/** L'index du tableau des 5 dernières valeurs */
	private int where = 0;
	
	/** booléen pour l'initialisation du tableau de valeurs enregistrées */
	private boolean init = true;

	/**
	 * @see Meteo.Capteur_pm#toString()
	 */
	@Override
	public String toString() {
		return (super.toString() + " tendance=" + this.get_trend());
	}

	/**
	 * Instantiates a new capteur_pmt.
	 *
	 * @param unités la liste d'unités associées au capteur
	 * @param name le nom du capteur
	 * @param observable l'observable associé
	 * @param plage_min la min de la plage
	 * @param plage_max le max de la plage
	 * @throws Exception l'éventuelle exception
	 */
	public Capteur_pmt(List<unit> unités, String name, Observable observable,
			float plage_min, float plage_max) throws Exception {
		super(unités, name, observable, plage_min, plage_max);
		this.clear_trend();
		}

	/**
	 * renvoie la tendance calculé
	 * 
	 * @return float la tendance
	 * @see Meteo.I_capteur_trend#get_trend()
	 */
	public float get_trend() {
		float trend = 0;
		int poids = 0;
		if (init == true && where == 0) {
			return 0;
		}
		if (init == true) {
			for (int i = 1; i < where; i++) {
				trend = (trend * poids + (last5[i] - last5[i - 1]))
						/ (poids + 1);
				poids++;
			}
		} else {
			for (int i = 1; i < 5; i++) {
				trend = (trend * poids + (last5[i] - last5[i - 1]))
						/ (poids + 1);
				poids++;
			}
		}
		int intermédiaire = (int) trend * 100;
		return ((float)intermédiaire / 100);
	}

	/**
	 * réinitialise la tendance
	 * @see Meteo.I_capteur_trend#clear_trend()
	 */
	@Override
	public void clear_trend() {
		int i;
		for (i = 0; i < 5; i++)
			last5[i] = 0F;
		init = true;
		where = 0;
	}

	/**
	 * @see Meteo.Capteur_pm#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		last5[where] = valeur;
		where++;
		if (where >= 5) {
			where = 0;
			init = false;
		}
	}

}
