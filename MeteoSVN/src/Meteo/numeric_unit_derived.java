package Meteo;

public class numeric_unit_derived extends numeric_unit {

	public numeric_unit_derived(String symbol, int précision, float décalage,
			float multiplicateur, String description) {
		super(symbol, précision, description);
		this.décalage = décalage;
		this.multiplicateur = multiplicateur;
	}

	private float multiplicateur;
	private float décalage;

	@Override
	public String getFormattedValue(float valeur) {
		return (valeur * multiplicateur + décalage) + " " + this.getsymbol();
	}

}
