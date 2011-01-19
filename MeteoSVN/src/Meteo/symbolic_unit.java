package Meteo;

public class symbolic_unit extends unit {
	/**
	 * @param tab_extr�mes Le tableau contenant les extr�mes des plages d'unit�s symboliques
	 * @param tableau_valeurs Le tableau contenant les valeurs des plages d'unit�s symboliques
	 * @param description Description de l'unit�
	 * @param symbol le symbole de l'unit�
	 */
	public symbolic_unit(float[] tab_extr�mes, String[] tableau_valeurs,
			String description, String symbol) {
		super(description, symbol);
	}

	/**
	 * @uml.property name="tab_extr�mes" multiplicity="(0 -1)" dimension="1"
	 */
	public float[] tab_extr�mes;
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
		if ((length = tab_valeurs.length) != tab_extr�mes.length)
			throw new Exception("les tableaux sont de taille diff�rentes !");
		for (i = 0; i < length; i++) {
			if (valeur < tab_extr�mes[i])
				return tab_valeurs[i];
		}
		return tab_valeurs[length];
	}
}
