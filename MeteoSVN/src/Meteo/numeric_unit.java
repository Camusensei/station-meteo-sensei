package Meteo;


public class numeric_unit extends unit {
	public numeric_unit(String symbol, int précision, String description){
		super(description,symbol);
		this.précision=précision;
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
