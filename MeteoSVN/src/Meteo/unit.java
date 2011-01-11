package Meteo;


public abstract class unit {
	protected String Description;
	public abstract String getFormattedValue(float valeur) throws Exception;
	public String getDescription(){
		return Description;
	};

}
