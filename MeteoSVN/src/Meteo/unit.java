package Meteo;

public abstract class unit {
	public unit(String description, String symbol) {
		super();
		Description = description;
		Symbol = symbol;
	}

	@Override
	public String toString() {
		return (this.Symbol);
	}

	private String Description;
	private String Symbol;

	public abstract String getFormattedValue(float valeur) throws Exception;

	public String getDescription() {
		return Description;
	};

	protected String getsymbol() {
		return Symbol;
	};

}
