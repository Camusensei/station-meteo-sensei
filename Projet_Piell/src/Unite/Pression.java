package Unite;

public class Pression extends Unite {

	@Override
	public String convert(double val, Unite dest) {
		if (dest.getUnite_base().equals("mmHG"))
			return hPa_to_mmHg(val);
		else if (dest.getUnite_base().equals("hPa"))
			return Double.toString(Math.round(val * 100) / 100);
		else if (dest.getUnite_base().equals("poHG"))
			return hPa_to_poHg(val);
		else if (dest.getUnite_base().equals("mB"))
			return Double.toString(Math.round(val * 100) / 100);
		else
			return "";
	}

	/**
		 */
	/*
	 * public String hPa_to_mbars(float val){ return Float.toString(val); }
	 */

	/**
			 */
	public String hPa_to_mmHg(double val) {
		double mmHg = val * 0.75;
		mmHg = Math.round(mmHg * 100) / 100;
		return Double.toString(Math.round(mmHg * 100) / 100);
	}

	/**
				 */
	public String hPa_to_poHg(double val) {
		double poHg = val * 0.033865;
		poHg = Math.round(poHg * 100) / 100;
		return Double.toString(Math.round(poHg * 100) / 100);
	}

	public Pression(String s) {
		this.setUnite_base(s);
	}

}
