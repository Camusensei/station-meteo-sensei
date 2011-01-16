package Meteo;

public interface I_capteur_Trend {

	public abstract String get_trend();

	/**
			 */
	public abstract float get_trend_value();

	/**
				 */
	public abstract void clear_trend();

}
