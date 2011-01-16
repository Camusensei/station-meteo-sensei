package Unite;

public class Sens_vent extends Unite {

	@Override
	public String convert(double val, Unite dest) {
		if (dest.getUnite_base().equals("DEG"))
			return rad_to_deg(val);
		else if (dest.getUnite_base().equals("RAD"))
			return Double.toString(Math.round(val * 100) / 100);
		else if (dest.getUnite_base().equals("DIR"))
			return rad_to_dir(val);
		else
			return "";
	}

	/**
		 */
	public String rad_to_deg(double val) {
		double deg = val * 180 / Math.PI;
		deg = Math.round(deg * 100) / 100;
		return Double.toString(deg);
	}

	/**
			 */
	public String rad_to_dir(double val) {
		if ((15 * Math.PI / 8) < val & val < (Math.PI / 8))
			return "Est";
		else if ((Math.PI / 8) < val & val < (3 * Math.PI / 8))
			return "Nord-Est";
		else if ((3 * Math.PI / 8) < val & val < (5 * Math.PI / 8))
			return "Nord";
		else if ((5 * Math.PI / 8) < val & val < (7 * Math.PI / 8))
			return "Nord-Ouest";
		else if ((7 * Math.PI / 8) < val & val < (9 * Math.PI / 8))
			return "Ouest";
		else if ((9 * Math.PI / 8) < val & val < (11 * Math.PI / 8))
			return "Sud-Ouest";
		else if ((11 * Math.PI / 8) < val & val < (13 * Math.PI / 8))
			return "Sud";
		else
			return "Sud-Est";
	}

	public Sens_vent(String s) {
		this.setUnite_base(s);
	}

}
