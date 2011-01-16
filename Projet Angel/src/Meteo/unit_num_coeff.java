package Meteo;

import java.text.DecimalFormat;

public class unit_num_coeff extends unit_num {

	protected double coefficient;
	protected double decalage;
	
	public void setFormattedValue (double val) 
	{
		DecimalFormat form = new DecimalFormat(getFormat());
		FormattedValue=form.format(val * coefficient + decalage);
	}

	public unit_num_coeff(String formatval, String symbol, String descr, String format,
			int precision, double coefficient, double decalage) {
		super(formatval, symbol, descr, format, precision);
		this.coefficient = coefficient;
		this.decalage = decalage;
	}

}
