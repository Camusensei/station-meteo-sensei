package Unite;
public class Humidite extends Unite {

	@Override
	public String convert(double d, Unite dest) {
		return Double.toString(Math.round(d * 100) / 100);
	}

	public Humidite(String s) {
		this.setUnite_base(s);
	}

}
