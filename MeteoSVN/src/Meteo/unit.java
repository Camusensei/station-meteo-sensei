package Meteo;

public abstract class unit {
	/**
	 * @param description la description de l'unitée
	 * @param symbol le symbole de l'unité
	 */
	public unit(String description, String symbol) {
		super();
		Description = description;
		Symbol = symbol;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (this.Symbol);
	}

	/**
	 * la description de l'unitée
	 */
	private String Description;
	/**
	 * le symbole de l'unité
	 */
	private String Symbol;

	/**
	 * Calcule la valeur formattée
	 * @param valeur la valeur de base à formatter
	 * @return la valeur formattée
	 * @throws Exception
	 */
	public abstract String getFormattedValue(float valeur) throws Exception;

	/**
	 * Récupère la description.
	 *
	 * @return la description
	 */
	public String getDescription() {
		return Description;
	};

	/**
	 * Récupère le symbole.
	 *
	 * @return le symbole
	 */
	protected String getsymbol() {
		return Symbol;
	};

}
