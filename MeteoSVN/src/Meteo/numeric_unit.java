package Meteo;

public class numeric_unit extends unit {
	/**
	 * @param symbol le symbole de l'unité
	 * @param précision la précision demandée (nombre de chiffres après la virgule)
	 * @param description la description de l'unité
	 */
	public numeric_unit(String symbol, int précision, String description) {
		super(description, symbol);
		this.précision = précision;
	}

	/**
	 * @uml.property name="Précision"
	 */
	public int précision;

	/**
	 * @see Meteo.unit#getFormattedValue(float)
	 */
	@Override
	public String getFormattedValue(float valeur) {
		int intermédiaire = (int) (valeur * Math.pow(10,précision)) ;
		return ""+(float) intermédiaire / Math.pow(10,précision);
	}

}
