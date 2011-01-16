package Meteo;

import java.text.DecimalFormat;

public class unit_num extends unit {
	protected String format;
	protected int precision;

	public unit_num(String formatval, String symbol, String description,
			String format, int precision) {
		super(formatval, symbol, description);
		this.format = format;
		this.precision = precision;
	}
	
	public void setFormattedValue (double val) {
		DecimalFormat form = new DecimalFormat(getFormat());
		FormattedValue=form.format(val);
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getPrecision() {
		return precision;
	}

}
