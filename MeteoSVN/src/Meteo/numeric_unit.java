package Meteo;

public class numeric_unit extends unit {
	/**
	 * @param symbol le symbole de l'unit�
	 * @param pr�cision la pr�cision demand�e (nombre de chiffres apr�s la virgule)
	 * @param description la description de l'unit�
	 */
	public numeric_unit(String symbol, int pr�cision, String description) {
		super(description, symbol);
		this.pr�cision = pr�cision;
	}

	/**
	 * @uml.property name="Pr�cision"
	 */
	public int pr�cision;

	/**
	 * @see Meteo.unit#getFormattedValue(float)
	 */
	@Override
	public String getFormattedValue(float valeur) {
		int interm�diaire = (int) (valeur * Math.pow(10,pr�cision)) ;
		return ""+(float) interm�diaire / Math.pow(10,pr�cision);
	}

}
