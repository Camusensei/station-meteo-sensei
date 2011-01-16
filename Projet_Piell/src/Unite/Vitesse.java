package Unite;

public class Vitesse extends Unite {

	@Override
	public String convert(double val, Unite dest) {
		if (dest.getUnite_base().equals("MS"))
			return kmh_to_ms(val);
		else if (dest.getUnite_base().equals("MH"))
			return kmh_to_mh(val);
		else if (dest.getUnite_base().equals("KMH"))
			return Double.toString(Math.round(val * 100) / 100);
		else if (dest.getUnite_base().equals("N"))
			return kmh_to_n(val);
		else if (dest.getUnite_base().equals("BF"))
			return kmh_to_beaufort_num(val);
		else
			return "";
	}

	/**
		 */
	public String kmh_to_ms(double val) {
		double ms = val / 3.6;
		ms = Math.round(ms * 100) / 100;
		return Double.toString(ms);
	}

	/**
			 */
	public String kmh_to_mh(double val) {
		double Mh = val * 0.621371;
		Mh = Math.round(Mh * 100) / 100;
		return Double.toString(Mh);
	}

	/**
				 */
	public String kmh_to_n(double val) {
		double noeud = val * 0.539613;
		noeud = Math.round(noeud * 100) / 100;
		return Double.toString(noeud);
	}

	/**
					 */
	public String kmh_to_beaufort_num(double val) {
		int beaufort = (int) Math.pow(val * val / 9, 1.0 / 3);
		beaufort = Math.round(beaufort * 100) / 100;
		return String.valueOf(beaufort);
	}

	public Vitesse(String s) {
		this.setUnite_base(s);
	}

}