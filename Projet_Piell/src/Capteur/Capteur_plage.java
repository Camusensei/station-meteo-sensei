package Capteur;

import java.util.Observable;

import Sonde.Sonde;
import Unite.Unite;

public class Capteur_plage extends Capteur {

	/**
	 * @uml.property name="minPlage"
	 */
	private double minPlage;

	/**
	 * Getter of the property <tt>minPlage</tt>
	 * 
	 * @return Returns the minPlage.
	 * @uml.property name="minPlage"
	 */
	public double getMinPlage() {
		return minPlage;
	}

	/**
	 * Setter of the property <tt>minPlage</tt>
	 * 
	 * @param minPlage
	 *            The minPlage to set.
	 * @uml.property name="minPlage"
	 */
	public void setMinPlage(double minPlage) {
		this.minPlage = minPlage;
	}

	/**
	 * @uml.property name="maxPlage"
	 */
	private double maxPlage;

	/**
	 * Getter of the property <tt>maxPlage</tt>
	 * 
	 * @return Returns the maxPlage.
	 * @uml.property name="maxPlage"
	 */
	public double getMaxPlage() {
		return maxPlage;
	}

	/**
	 * Setter of the property <tt>maxPlage</tt>
	 * 
	 * @param maxPlage
	 *            The maxPlage to set.
	 * @uml.property name="maxPlage"
	 */
	public void setMaxPlage(double maxPlage) {
		this.maxPlage = maxPlage;
	}

	@Override
	public synchronized void update(Observable sonde, Object val) {
		System.out.print("Température capteur inté : ");
		System.out.println(getValeur());
		Sonde sonde2 = new Sonde(0, 0, 0);
		if (sonde.getClass().equals(sonde2.getClass())) {
			double val2 = ((Sonde) sonde).getValeur();
			if (val2 < minPlage) {
				val2 = minPlage;
				this.setDepassement(true);
			} else if (val2 > maxPlage) {
				val2 = maxPlage;
				this.setDepassement(true);
			} else {
				this.setDepassement(false);
			}
			setValeur(val2);
		}
	}

	public Capteur_plage(Unite u, String nom, double d, double e) {
		super(u, nom);
		minPlage = d;
		maxPlage = e;
	}

	/**
	 * @uml.property name="depassement"
	 */
	private boolean depassement;

	/**
	 * Getter of the property <tt>depassement</tt>
	 * 
	 * @return Returns the depassement.
	 * @uml.property name="depassement"
	 */
	public boolean isDepassement() {
		return depassement;
	}

	/**
	 * Setter of the property <tt>depassement</tt>
	 * 
	 * @param depassement
	 *            The depassement to set.
	 * @uml.property name="depassement"
	 */
	public void setDepassement(boolean depassement) {
		this.depassement = depassement;
	}

}
