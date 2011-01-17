package Meteo;

public class numeric_unit_derived extends numeric_unit {

	public numeric_unit_derived(String symbol, int pr�cision, float d�calage,
			float multiplicateur, String description) {
		super(symbol, pr�cision, description);
		this.d�calage = d�calage;
		this.multiplicateur = multiplicateur;
	}

	private float multiplicateur;
	private float d�calage;

	@Override
	public String getFormattedValue(float valeur) {
		return (valeur * multiplicateur + d�calage) + " " + this.getsymbol();
	}

}
