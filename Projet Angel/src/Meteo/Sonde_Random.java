package Meteo;

public class Sonde_Random extends Sonde {

	private double min;
	private double max;
	private double variation;
	private long delai; // en milisecondes
	
	public Sonde_Random(double min, double max, double variation, long delai) 
	{this.min=min; this.max=max; this.variation=variation; this.setDelai(delai);}
	
	public void run () {
		try {Thread.sleep(delai);} 
		catch (InterruptedException e) {e.printStackTrace();}
		fetch_Value();
		notifyObservers(this);
	}
	
	public double fetch_Value() {
		double random;
		if (valeur==0.0){System.out.println("boucle 0");
			random= Math.random() * (max-min) + min;
			this.setValeur(random);
		}
		else {System.out.println("boucle 1");
		random=Math.random() * (variation*2) + valeur-variation;
		this.setValeur(random);}
		System.out.println(valeur);
		return valeur;
	}

		
	public void setDelai(long delai) {
		this.delai = delai;
	}

	public long getDelai() {
		return delai;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getVariation() {
		return variation;
	}

	public void setVariation(double variation) {
		this.variation = variation;
	}
	
		
	

}
