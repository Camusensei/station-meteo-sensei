package Meteo;

import java.util.Observable;

public abstract class Capteur_pmt extends Capteur_pm implements I_capteur_trend {

	private float[] last5;
	private int where = 0;
	private boolean init = true;

	public Capteur_pmt(Observable obs,String name) {
		super(obs,name);
		where = 0;
		init = true;
		for (int i = 0; i < 5; i++) {
			last5[i] = 0;
		}
	}

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
		return trend;
	}

	@Override
	public void clear_trend() {
		int i;
		for (i = 0; i < 5; i++)
			last5[i] = 0;
		init = true;
		where = 0;
		// TODO Auto-generated method stub

	}

	/**
			 */
	@Override
	public void update(Observable obs, Object arg1) {
		super.update(obs, arg1);
		last5[where]=valeur;
		where++;
		if (where>=5){
			where=0;
			init=false;
		}
	}
	
}
