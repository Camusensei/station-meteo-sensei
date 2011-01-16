package Sonde;
import Capteur.AbstractCapteur;
import Capteur.Capteur;

public class Sonde extends AbstractSonde {

	/**
	 * @uml.property name="valMin"
	 */
	private double valMin;

	/**
	 * Getter of the property <tt>valMin</tt>
	 * 
	 * @return Returns the valMin.
	 * @uml.property name="valMin"
	 */
	public double getValMin() {
		return valMin;
	}

	/**
	 * Setter of the property <tt>valMin</tt>
	 * 
	 * @param valMin
	 *            The valMin to set.
	 * @uml.property name="valMin"
	 */
	public void setValMin(float valMin) {
		this.valMin = valMin;
	}

	/**
	 * @uml.property name="valMax"
	 */
	private double valMax;

	/**
	 * Getter of the property <tt>valMax</tt>
	 * 
	 * @return Returns the valMax.
	 * @uml.property name="valMax"
	 */
	public double getValMax() {
		return valMax;
	}

	/**
	 * Setter of the property <tt>valMax</tt>
	 * 
	 * @param valMax
	 *            The valMax to set.
	 * @uml.property name="valMax"
	 */
	public void setValMax(float valMax) {
		this.valMax = valMax;
	}

	/**
	 * @uml.property name="varMax"
	 */
	private double varMax;

	/**
	 * Getter of the property <tt>varMax</tt>
	 * 
	 * @return Returns the varMax.
	 * @uml.property name="varMax"
	 */
	public double getVarMax() {
		return varMax;
	}

	/**
	 * Setter of the property <tt>varMax</tt>
	 * 
	 * @param varMax
	 *            The varMax to set.
	 * @uml.property name="varMax"
	 */
	public void setVarMax(double varMax) {
		this.varMax = varMax;
	}

	/**
	 * @uml.property name="delai"
	 */
	private int delai;

	/**
	 * Getter of the property <tt>delai</tt>
	 * 
	 * @return Returns the delai.
	 * @uml.property name="delai"
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * Setter of the property <tt>delai</tt>
	 * 
	 * @param delai
	 *            The delai to set.
	 * @uml.property name="delai"
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	private class MiseaJour extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000 * delai);
					// System.out.println("Pression : ".concat(pression));
					setChanged();
					if (getValeur() < valMin - 1) {
						double val = (Math.random() * (valMax - valMin) + valMin);
						setValeur(val);
						notifyObservers(val);
					} else {
						double var = Math.random();
						var = (var * varMax) - (varMax / 2.0);
						double val = getValeur();
						if ((var + val) > valMax) {
							setValeur(valMax);
							notifyObservers(valMax);
						} else if ((var + val) < valMin) {
							setValeur(valMin);
							notifyObservers(valMin);
						} else {
							setValeur(var + val);
							notifyObservers(var + val);
						}
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public void start() {
		MiseaJour miseajour = new MiseaJour();
		miseajour.start();
	}

	public Sonde(double valeurMin, double valeurMax, double variation) {
		valMin = valeurMin;
		valMax = valeurMax;
		varMax = variation;
		delai = 1;
		double val = (Math.random() * (valMax - valMin) + valMin);
		setValeur(val);
		notifyObservers(val);
	}

	public Sonde(double valeurMin, double valeurMax, double variation, int d) {
		valMin = valeurMin;
		valMax = valeurMax;
		varMax = variation;
		delai = d;
		double val = (Math.random() * (valMax - valMin) + valMin);
		setValeur(val);
		notifyObservers(val);
	}
	
	public Sonde(double valeurMin, double valeurMax, double variation, int d, Capteur c) {
		valMin = valeurMin;
		valMax = valeurMax;
		varMax = variation;
		delai = d;
		this.addObserver(c);
		double val = (Math.random() * (valMax - valMin) + valMin);
		setValeur(val);
		notifyObservers(val);
	}

	@Override
	public void registerCapteur(AbstractCapteur obs) {

	}

}
