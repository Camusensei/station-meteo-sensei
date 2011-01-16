package Meteo;

//import java.util.Observable;
//import java.util.Observer;
//import java.util.Collection;
import java.util.*;
import java.text.DecimalFormat; 



public abstract class Capteur_meteo extends unit implements Observer{

	protected double value;
	protected String ID;
	private Collection<unit> unites;
	
		
	public Capteur_meteo(String formatval, String symbol, String descr,
			double value, String iD, Collection<unit> unites) {
		super(formatval, symbol, descr);
		this.value = value;
		ID = iD;
		this.unites = unites;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public double get_valeur() {
		System.out.println("valeur : "+value);
		return value;
	}

	public String conversion (unit_num_coeff u) {
		if(unites.contains(u))
		{
			double result = u.coefficient * value + u.decalage;
			String masque = new String(u.getFormat());
			DecimalFormat form = new DecimalFormat(masque);
			String res=form.format(result);
			System.out.println(res+" "+u.getSymbol());
			return res;
		}
		else {System.err.println("erreur d'unite"); return "";}
	}
	
	public String conversion (unit_num u) {
		if(unites.contains(u))
		{
			String masque = new String(u.getFormat());
			DecimalFormat form = new DecimalFormat(masque);
			String res=form.format(value);
			System.out.println(res+" "+u.getSymbol());
			return res;
		}
		else {System.err.println("erreur d'unite"); return "";}
	}

	public String conversion (unit_string u) { return "";
	
	

}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		value=((Sonde) arg1).getValeur();
		/*Collection<unit> test = null;
		Observable test2 = null;
		if (unites != test)
			return;
		if (observable != test2)
			return;*/

	}

	
}
