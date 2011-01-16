package Meteo;

import java.util.Random;

public class sonde_random extends sonde {

	public sonde_random(float min, float f) {
		super();
		this.min = min;
		this.max = f;
	}
	/**
	 * @uml.property  name="min"
	 */
	private float min;
	/**
	 * @uml.property  name="max"
	 */
	private float max;
	Random r = new Random(0); // Seed for reproducible testing
	public void setData(){
		super.change((r.nextFloat()*(Math.abs(max-min)))-min);
	};
}
