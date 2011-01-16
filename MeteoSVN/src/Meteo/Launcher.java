package Meteo;

import java.util.ArrayList;

public class Launcher {
	static numeric_unit radians;
	static numeric_unit_derived degr�s;
	static symbolic_unit direction_symbolique;
	static ArrayList<unit>  unit�s_direction=new ArrayList<unit>(3);
	private static void create_units(){
		/* UNIT�S DE DIRECTIONS : D�BUT */
		degr�s=new numeric_unit_derived("� (Degr�s)", 0,
				0, 57.29578F, "Unit� : Degr�s. Repr�sentent l'angle math�matique (de 0 � 360)");
		radians=new numeric_unit("Radians", 2,
				"Unit� : Radians. Repr�sentent l'angle math�matique (de 0 � 2*Pi = 6,2832)");
		float[] direction_extr�mes={0F,0.3927F,1.1781F,1.9635F,2.7489F,3.5343F,4.3197F,5.1051F,5.8905F,6.2832F};
		String[] direction_symboles={"Nord","Nord-Est","Est","Sud-Est","Sud","Sud-Ouest","Ouest","Nord-Ouest","Nord"};
		direction_symbolique=new symbolic_unit(direction_extr�mes, direction_symboles,
				"Unit� : Direction symbolique. Repr�sente les directions de la boussole (Nord, Sud, Est, Ouest et leurs combinaisons)","Direction Symbolique");
		unit�s_direction.add(radians);
		unit�s_direction.add(degr�s);
		unit�s_direction.add(direction_symbolique);
		/* UNIT�S DE DIRECTIONS : FIN */
		/* UNIT�S DE VITESSE : D�BUT */
		/* UNIT�S DE VITESSE : FIN */
		/* UNIT�S D'HUMIDIT� : D�BUT */
		/* UNIT�S D'HUMIDIT� : FIN */
		/* UNIT�S DE TEMP�RATURE : D�BUT */
		/* UNIT�S DE TEMP�RATURE : FIN */
		/* UNIT�S DE PRESSION : D�BUT */
		/* UNIT�S DE PRESSION : FIN */
		/* UNIT�S SUPL�MENTAIRES : D�BUT */
		/* UNIT�S SUPL�MENTAIRES : FIN */
	};
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		create_units();
		sonde_random Random0_360=new sonde_random(10000L, 0, 360);
		new Thread((Runnable) Random0_360).start();
		Capteur_base capteur=new girouette(unit�s_direction, "girouette", Random0_360);
		System.out.println(capteur);
	}

}
