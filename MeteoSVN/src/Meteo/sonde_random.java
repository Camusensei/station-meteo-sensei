package Meteo;

import java.util.Random;

public class sonde_random extends sonde {

	/**
	 * @param time_ms le temps en milisecondes d'attente entre deux nouvelles valeurs
	 * @param min le minimum à ne pas dépasser pour la généaration aléatoire
	 * @param max le maximum à ne pas dépasser pour la généaration aléatoire
	 */
	public sonde_random(long time_ms, float min, float max) {
		super(time_ms);
		this.min = min;
		this.max = max;
	}

	/**
	 * @uml.property name="min"
	 */
	private float min;
	/**
	 * @uml.property name="max"
	 */
	private float max;
	Random r = new Random();

	/**
	 * @see Meteo.sonde#setData()
	 */
	@Override
	public void setData() {
		super.change(min+((max-min+1)*r.nextFloat()));
	};
}
