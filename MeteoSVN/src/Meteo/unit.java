package Meteo;

public abstract class unit {
	/**
	 * @param description la description de l'unit�e
	 * @param symbol le symbole de l'unit�
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

	private String Description;
	private String Symbol;

	/**
	 * Calcule la valeur formatt�e
	 * @param valeur la valeur de base � formatter
	 * @return la valeur formatt�e
	 * @throws Exception
	 */
	public abstract String getFormattedValue(float valeur) throws Exception;

	/**
	 * R�cup�re la description.
	 *
	 * @return la description
	 */
	public String getDescription() {
		return Description;
	};

	/**
	 * R�cup�re le symbole.
	 *
	 * @return le symbole
	 */
	protected String getsymbol() {
		return Symbol;
	};

}
