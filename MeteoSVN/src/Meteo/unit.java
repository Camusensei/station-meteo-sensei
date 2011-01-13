package Meteo;


public abstract class unit {
	public unit(String description, String symbol) {
		super();
		Description = description;
		Symbol = symbol;
	}
	protected String Description;
	protected String Symbol;
	public abstract String getFormattedValue(float valeur) throws Exception;
	public String getDescription(){
		return Description;
	};
	public String getsymbol(){
		return Symbol;
	};

}
