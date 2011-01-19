package Meteo;

public class numeric_unit_derived extends numeric_unit {

	/**
	 * @param symbol le symbole de l'unit�
	 * @param pr�cision la pr�cision demand�e (nombre de chiffres apr�s la virgule)
	 * @param d�calage la quantit� � ajouter � la valeur de base
	 * @param multiplicateur la quantit� � multuplier par la valeur de base
	 * @param description la description de l'unit�
	 */
	public numeric_unit_derived(String symbol, int pr�cision, float d�calage,
			float multiplicateur, String description) {
		super(symbol, pr�cision, description);
		this.d�calage = d�calage;
		this.multiplicateur = multiplicateur;
	}

	/**
	 * multiplicateur la quantit� � multuplier par la valeur de base
	 */
	private float multiplicateur;
	/**
	 * la quantit� � ajouter � la valeur de base
	 */
	private float d�calage;

	/**
	 * @see Meteo.numeric_unit#getFormattedValue(float)
	 */
	@Override
	public String getFormattedValue(float valeur) {
		int interm�diaire = (int) ((valeur * multiplicateur + d�calage) * Math.pow(10,pr�cision));
		return ""+(float) interm�diaire / Math.pow(10,pr�cision);
	}
}
