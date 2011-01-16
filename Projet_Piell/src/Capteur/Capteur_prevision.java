package Capteur;

import java.util.Observable;

import Sonde.Sonde;
import Unite.Unite;

public class Capteur_prevision extends Capteur_minmax {

	/**
	 * @uml.property name="mesures"
	 */
	private double[] mesures;

	/**
	 * Getter of the property <tt>mesures</tt>
	 * 
	 * @return Returns the mesures.
	 * @uml.property name="mesures"
	 */
	public double[] getMesures() {
		return mesures;
	}

	/**
	 * Setter of the property <tt>mesures</tt>
	 * 
	 * @param mesures
	 *            The mesures to set.
	 * @uml.property name="mesures"
	 */
	public void setMesures(double[] mesures) {
		this.mesures = mesures;
	}

	/**
		 */
	public double tendance() {
		float s = 0;
		int nb_mesures = 0;
		for (int i = 0; i < mesures.length; i++) {
			if (mesures[i] > getMinPlage() && mesures[i] < getMaxPlage()) {
				s += mesures[i];
				nb_mesures++;
			}

		}
		s = s / nb_mesures;
		double diff = mesures[mesures.length - 1] - s;
		diff = diff / s * 100;

		/*
		 * float temp [] = mesures.clone(); for (int i = 0;i <
		 * mesures.length-1;i++) { for (int j = 1;j < mesures.length-i;j++) {
		 * temp[j-1] = (temp[j-1]+temp[j])/2; } } float a = 1/(temp[1]-temp[0]);
		 * float b = temp[0]*a; float y1 = 10; float x1 = (y1-b)/a; float x2 =
		 * -b/a; float ang = (float) Math.atan((double) (y1/(x2-x1))); float
		 * pourc = 200*ang/(float)Math.PI; return pourc;
		 */
		if (nb_mesures != 0) {
			return Math.round(diff * 100) / 100;
		}
		else return 0;
	}

	@Override
	public void update(Observable sonde, Object val) {
		Sonde sonde2 = new Sonde(0, 0, 0);
		if (sonde.getClass().equals(sonde2.getClass())) {
			double val2 = ((Sonde) sonde).getValeur();
			if (val2 < getMinPlage()) {
				val2 = getMinPlage();
				this.setDepassement(true);
				notifyObservers(this.getValeur());
			} else if (val2 > getMaxPlage()) {
				val2 = getMaxPlage();
				this.setDepassement(true);
				notifyObservers(this.getValeur());
			} else {
				this.setDepassement(false);
				notifyObservers(this.getValeur());
			}
			setValeur(val2);
			if (val2 > getMaximum_reel()) {
				setMaximum(val2);
			}
			if (val2 < getMinimum_reel()) {
				setMinimum(val2);
			}
			for (int i = 1; i < mesures.length; i++) {
				mesures[i - 1] = mesures[i];
			}
			mesures[mesures.length - 1] = val2;
		}
	}

	public Capteur_prevision(Unite u, String nom, double d, double e, int taille) {
		super(u, nom, d, e);
		mesures = new double[taille];
		for (int i = 0; i < taille; i++) {
			mesures[i] = d - 1;
		}
	}

	/**
		 */
	public void reset_tendance() {
		for (int i = 0; i < mesures.length; i++) {
			mesures[i] = getMinPlage() - 1;
		}
	}
}
