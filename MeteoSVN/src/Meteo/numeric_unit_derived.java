package Meteo;

public class numeric_unit_derived extends numeric_unit {

	/**
	 * @param symbol le symbole de l'unité
	 * @param précision la précision demandée (nombre de chiffres après la virgule)
	 * @param décalage la quantité à ajouter à la valeur de base
	 * @param multiplicateur la quantité à multuplier par la valeur de base
	 * @param description la description de l'unité
	 */
	public numeric_unit_derived(String symbol, int précision, float décalage,
			float multiplicateur, String description) {
		super(symbol, précision, description);
		this.décalage = décalage;
		this.multiplicateur = multiplicateur;
	}

	/**
	 * multiplicateur la quantité à multuplier par la valeur de base
	 */
	private float multiplicateur;
	/**
	 * la quantité à ajouter à la valeur de base
	 */
	private float décalage;

	/**
	 * @see Meteo.numeric_unit#getFormattedValue(float)
	 */
	@Override
	public String getFormattedValue(float valeur) {
		int intermédiaire = (int) ((valeur * multiplicateur + décalage) * Math.pow(10,précision));
		return ""+(float) intermédiaire / Math.pow(10,précision);
	}
}
