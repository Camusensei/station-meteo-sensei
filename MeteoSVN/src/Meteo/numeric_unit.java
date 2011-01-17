package Meteo;

public class numeric_unit extends unit {
	public numeric_unit(String symbol, int précision, String description) {
		super(description, symbol);
		this.précision = précision;
	}

	/**
	 * @uml.property name="Précision"
	 */
	public int précision;

	@Override
	public String getFormattedValue(float valeur) {
		int intermédiaire = (int) (valeur * Math.pow(10,précision)) ;
		return ""+(float) intermédiaire / Math.pow(10,précision);
	}

}
