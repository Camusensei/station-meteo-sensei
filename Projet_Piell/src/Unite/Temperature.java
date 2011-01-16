package Unite;

public class Temperature extends Unite {

	@Override
	public String convert(double val, Unite dest) {
		if (dest.getUnite_base().equals("FAHR"))
			return cel_to_fahr(val);
		else if (dest.getUnite_base().equals("KEL"))
			return cal_to_kelvin(val);
		else if (dest.getUnite_base().equalsIgnoreCase("CEL"))
			return Double.toString(Math.round(val * 100) / 100);
		else
			return dest.getUnite_base();
	}

	/**
		 */
	public String cel_to_fahr(double val) {
		double fahr = (val * (1.8)) + 32;
		fahr = Math.round(fahr * 100) / 100;
		return Double.toString(fahr);
	}

	/**
			 */
	public String cal_to_kelvin(double val) {
		double kelvin = val + 273.15;
		kelvin = Math.round(kelvin * 100) / 100;
		return Double.toString(kelvin);
	}

	public Temperature(String s) {
		this.setUnite_base(s);
	}

}
