package Capteur;

import java.util.Observable;
import java.util.Observer;

import Unite.Unite;

public abstract class AbstractCapteur extends Observable implements Observer {

	/**
	 * @uml.property name="valeur"
	 */
	private double valeur;

	/**
	 * Getter of the property <tt>valeur</tt>
	 * 
	 * @return Returns the valeur.
	 * @uml.property name="valeur"
	 */
	public double getValeur_base() {
		return valeur;
	}

	/**
	 * Setter of the property <tt>valeur</tt>
	 * 
	 * @param val2
	 *            The valeur to set.
	 * @uml.property name="valeur"
	 */
	public void setValeur(double val2) {
		this.valeur = val2;
	}

	public AbstractCapteur(Unite u, String nom) {
		setUnite(u);
		setUnite_act(u);
		setName(nom);
	}

	/**
	 * @uml.property name="unite"
	 */
	private Unite unite;

	/**
	 * Getter of the property <tt>unite</tt>
	 * 
	 * @return Returns the unite.
	 * @uml.property name="unite"
	 */
	public Unite getUnite() {
		return unite;
	}

	/**
	 * Setter of the property <tt>unite</tt>
	 * 
	 * @param unite
	 *            The unite to set.
	 * @uml.property name="unite"
	 */
	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	/**
	 * @uml.property name="name"
	 */
	private String name;

	/**
	 * Getter of the property <tt>name</tt>
	 * 
	 * @return Returns the name.
	 * @uml.property name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * 
	 * @param name
	 *            The name to set.
	 * @uml.property name="name"
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property name="unite_act"
	 */
	private Unite uniteAct;

	/**
	 * Getter of the property <tt>unite_act</tt>
	 * 
	 * @return Returns the uniteAct.
	 * @uml.property name="unite_act"
	 */
	public Unite getUnite_act() {
		return uniteAct;
	}

	/**
	 * Setter of the property <tt>unite_act</tt>
	 * 
	 * @param unite_act
	 *            The uniteAct to set.
	 * @uml.property name="unite_act"
	 */
	public void setUnite_act(Unite uniteAct) {
		this.uniteAct = uniteAct;
	}

}
