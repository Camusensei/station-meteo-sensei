package Meteo;


public class numeric_unit extends unit {
	public numeric_unit(String symbol, int précision, String description){
		super(symbol,description);
		this.précision=précision;
		this.Description=description;
	}
	/**
	 * @uml.property  name="Précision"
	 */
	public int précision;
	@Override
	public String getFormattedValue(float valeur) {
		return valeur + " " + this.getsymbol();
	}

}
