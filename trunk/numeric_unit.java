package Meteo;


public class numeric_unit extends unit {
	public numeric_unit(String symbol, int précision, float décalage, float multiplicateur, String description){
	}
	/**
	 * @uml.property  name="décalage"
	 */
	public float Décalage = 0F;
	/**
	 * @uml.property  name="Multiplicateur"
	 */
	public float multiplicateur = 1F;
	/**
	 * @uml.property  name="Précision"
	 */
	public String précision;
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
