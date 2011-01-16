package Capteur;

import java.util.Vector;

import Unite.Humidite;
import Unite.Pression;
import Unite.Sens_vent;
import Unite.Temperature;
import Unite.Vitesse;

public class Station {

	public Station() {
		capteurs = new Vector<AbstractCapteur>();
	}

	/**
	 * @uml.property name="capteur"
	 * @uml.associationEnd inverse="station:Capteur"
	 */
	private Vector<AbstractCapteur> capteurs;

	/**
	 * Getter of the property <tt>capteur</tt>
	 * 
	 * @return Returns the capteur.
	 * @uml.property name="capteur"
	 */
	public Vector<AbstractCapteur> getCapteurs() {
		return capteurs;
	}

	/**
	 * Setter of the property <tt>capteur</tt>
	 * 
	 * @param capteur
	 *            The capteur to set.
	 * @uml.property name="capteur"
	 */
	public void setCapteur(Vector<AbstractCapteur> capteur) {
		this.capteurs = capteur;
	}

	public void add(AbstractCapteur cap) {
		int i = 0;
		boolean remp = false;
		if (capteurs.equals(null)) {
			capteurs.add(cap);
		}
		for (AbstractCapteur c : capteurs) {
			if (c.getClass().equals(cap.getClass())) {
				capteurs.setElementAt(cap, i);
				remp = true;
				break;
			}
			i++;
		}
		if (!remp) {
			capteurs.add(cap);
		}
	}

	public Thermometre getTemperature() {
		Thermometre n = new Thermometre(new Temperature(""), "", 0, 0, 0);
		for (AbstractCapteur c : capteurs) {
			if (c.getClass().equals(n.getClass())) {
				return (Thermometre) c;
			}
		}
		return n;
	}

	public Barometre getPression() {
		Barometre n = new Barometre(new Pression(""), "", 0, 0, 0);
		for (AbstractCapteur c : capteurs) {
			if (c.getClass().equals(n.getClass())) {
				return ((Barometre) c);
			}
		}
		return n;
	}

	public Girouette getSensvent() {
		Girouette n = new Girouette(new Sens_vent(""), "");
		for (AbstractCapteur c : capteurs) {
			if (c.getClass().equals(n.getClass())) {
				return ((Girouette) c);
			}
		}
		return n;
	}

	public Anemometre getVitesse() {
		Anemometre n = new Anemometre(new Vitesse(""), "", 0, 0);
		for (AbstractCapteur c : capteurs) {
			if (c.getClass().equals(n.getClass())) {
				return ((Anemometre) c);
			}
		}
		return n;
	}

	public Hygrometrie getHumidite() {
		Hygrometrie n = new Hygrometrie(new Humidite(""), "", 0, 0);
		for (AbstractCapteur c : capteurs) {
			if (c.getClass().equals(n.getClass())) {
				return ((Hygrometrie) c);
			}
		}
		return n;
	}
}