package Meteo;


public class numeric_unit extends unit {
	public numeric_unit(String symbol, int pr�cision, String description){
		super(symbol,description);
		this.pr�cision=pr�cision;
		this.Description=description;
	}
	/**
	 * @uml.property  name="Pr�cision"
	 */
	public int pr�cision;
	@Override
	public String getFormattedValue(float valeur) {
		return valeur + " " + this.getsymbol();
	}

}
