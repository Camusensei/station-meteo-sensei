package Meteo;

public class symbolic_unit extends unit {
	/**
	 * @param tab_extrèmes Le tableau contenant les extrèmes des plages d'unités symboliques
	 * @param tableau_valeurs Le tableau contenant les valeurs des plages d'unités symboliques
	 * @param description Description de l'unité
	 * @param symbol le symbole de l'unité
	 */
	public symbolic_unit(float[] tab_extrèmes, String[] tableau_valeurs,
			String description, String symbol) {
		super(description, symbol);
	}

	/**
	 * @uml.property name="tab_extrèmes" multiplicity="(0 -1)" dimension="1"
	 */
	public float[] tab_extrèmes;
	/**
	 * @uml.property name="tab_valeurs" multiplicity="(0 -1)" dimension="1"
	 */
	public String[] tab_valeurs;

	/**
	 * @see Meteo.unit#getFormattedValue(float)
	 */
	@Override
	public String getFormattedValue(float valeur) throws Exception {
		int i, length;
		if ((length = tab_valeurs.length) != tab_extrèmes.length)
			throw new Exception("les tableaux sont de taille différentes !");
		for (i = 0; i < length; i++) {
			if (valeur < tab_extrèmes[i])
				return tab_valeurs[i];
		}
		return tab_valeurs[length];
	}
}
