package Meteo;


public class numeric_unit extends unit {
	public numeric_unit(String symbol, int pr�cision, float d�calage, float multiplicateur, String description){
	}
	/**
	 * @uml.property  name="d�calage"
	 */
	public float D�calage = 0F;
	/**
	 * @uml.property  name="Multiplicateur"
	 */
	public float multiplicateur = 1F;
	/**
	 * @uml.property  name="Pr�cision"
	 */
	public String pr�cision;
	public String Symbol;
	@Override
	public String getFormattedValue(float valeur) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getsymbol(){
		return Symbol;
	};

}
