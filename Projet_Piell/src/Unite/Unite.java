package Unite;

public abstract class Unite {

	/**
	 * @uml.property name="unite_base"
	 */
	private String uniteBase;

	/**
	 * Getter of the property <tt>unite_base</tt>
	 * 
	 * @return Returns the uniteBase.
	 * @uml.property name="unite_base"
	 */
	public String getUnite_base() {
		return uniteBase;
	}

	/**
	 * Setter of the property <tt>unite_base</tt>
	 * 
	 * @param unite_base
	 *            The uniteBase to set.
	 * @uml.property name="unite_base"
	 */
	public void setUnite_base(String uniteBase) {
		this.uniteBase = uniteBase;
	}

	/**
		 */
	public abstract String convert(double d, Unite dest);

}
