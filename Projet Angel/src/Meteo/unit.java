package Meteo;

public class unit {

	protected String FormattedValue; // +00.000
	protected String symbol; //km/h
	protected String description;
	
	public unit (String formatval, String symbol, String descr) {
		FormattedValue=formatval;
		this.symbol=symbol;
		description=descr;
	}
	
	public String getFormattedValue() {return FormattedValue;}

	public String getSymbol() {
		return symbol;
	}

	public String getDescription() {
		return description;
	}

}
