package Capteur;

import java.util.Observable;

import Sonde.Sonde;
import Unite.Unite;

public class Capteur_minmax extends Capteur_plage {

	/**
	 * @uml.property name="maximum"
	 */
	private double maximum;

	/**
	 * Getter of the property <tt>maximum</tt>
	 * 
	 * @return Returns the maximum.
	 * @uml.property name="maximum"
	 */
	public double getMaximum() {
		if (maximum >= super.getMinPlage()) {
			return Math.round(maximum * 100) / 100;
		}
		else if (maximum >= getMaxPlage()) {
			return getMaxPlage();
		}
		else return 0;
	}
	
	public double getMaximum_reel() {
		return maximum;
	}

	/**
	 * Setter of the property <tt>maximum</tt>
	 * 
	 * @param d
	 *            The maximum to set.
	 * @uml.property name="maximum"
	 */
	public void setMaximum(double d) {
		this.maximum = d;
	}

	/**
	 * @uml.property name="minimum"
	 */
	private double minimum;

	/**
	 * Getter of the property <tt>minimum</tt>
	 * 
	 * @return Returns the minimum.
	 * @uml.property name="minimum"
	 */
	public double getMinimum() {
		if (minimum <= super.getMaxPlage()) {
			return Math.round(minimum * 100) / 100;
		}
		else if (minimum <= getMinPlage()) {
			return getMinPlage();
		}
		else return 0;
		
	}
	
	public double getMinimum_reel() {
		return minimum;
	}

	/**
	 * Setter of the property <tt>minimum</tt>
	 * 
	 * @param e
	 *            The minimum to set.
	 * @uml.property name="minimum"
	 */
	public void setMinimum(double e) {
		this.minimum = e;
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
			if (val2 > maximum) {
				setMaximum(val2);
			}
			if (val2 < minimum) {
				setMinimum(val2);
			}
		}
	}

	public Capteur_minmax(Unite u, String nom, double d, double e) {
		super(u, nom, d, e);
		setMinimum(getMaxPlage()+1);
		setMaximum(getMinPlage()-1);
	}

	/**
		 */
	public void reset_minmax() {
		setMinimum(getMaxPlage()+1);
		setMaximum(getMinPlage()-1);
	}

}
