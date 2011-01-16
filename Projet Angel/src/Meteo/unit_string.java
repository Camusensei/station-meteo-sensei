package Meteo;

public class unit_string extends unit {

	protected double[] valeurs;
	protected String[] description;
	
	public void setFormattedValue(double val) {
		int taille = valeurs.length;
		int set=0;
		for (int i=0; i<taille ; i++)
		{
			if (val<=valeurs[i]) {FormattedValue=description[i]; set=1; break;}
		}
		if (set==0){FormattedValue=description[taille];}	
		System.out.println("bob :"+FormattedValue);
	}
	
	public String getFormattedValue(double val) {
		int taille = valeurs.length;
		int set=0;
		for (int i=0; i<taille ; i++)
		{
			if (val<=valeurs[i]) {FormattedValue=description[i]; set=1; break;}
		}
		if (set==0){FormattedValue=description[taille];}	
		return /*System.out.println*/("bob :"+FormattedValue);
	}

	public unit_string(String formatval, String symbol, String descr, String [] description, double[] valeurs) {
		super(formatval, symbol, descr);
		this.valeurs=valeurs;
		this.description=description;
	}

}
