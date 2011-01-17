package Meteo;

public class numeric_unit extends unit {
	public numeric_unit(String symbol, int pr�cision, String description) {
		super(description, symbol);
		this.pr�cision = pr�cision;
	}

	/**
	 * @uml.property name="Pr�cision"
	 */
	public int pr�cision;

	@Override
	public String getFormattedValue(float valeur) {
		int interm�diaire = (int) (valeur * Math.pow(10,pr�cision)) ;
		return ""+(float) interm�diaire / Math.pow(10,pr�cision);
	}

}
