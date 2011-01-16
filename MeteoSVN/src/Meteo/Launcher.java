package Meteo;

import java.util.ArrayList;

public class Launcher {
	static numeric_unit radians;
	static numeric_unit_derived degrés;
	static symbolic_unit direction_symbolique;
	static ArrayList<unit>  unités_direction=new ArrayList<unit>(3);
	private static void create_units(){
		/* UNITÉS DE DIRECTIONS : DÉBUT */
		degrés=new numeric_unit_derived("° (Degrés)", 0,
				0, 57.29578F, "Unité : Degrés. Représentent l'angle mathématique (de 0 à 360)");
		radians=new numeric_unit("Radians", 2,
				"Unité : Radians. Représentent l'angle mathématique (de 0 à 2*Pi = 6,2832)");
		float[] direction_extrèmes={0F,0.3927F,1.1781F,1.9635F,2.7489F,3.5343F,4.3197F,5.1051F,5.8905F,6.2832F};
		String[] direction_symboles={"Nord","Nord-Est","Est","Sud-Est","Sud","Sud-Ouest","Ouest","Nord-Ouest","Nord"};
		direction_symbolique=new symbolic_unit(direction_extrèmes, direction_symboles,
				"Unité : Direction symbolique. Représente les directions de la boussole (Nord, Sud, Est, Ouest et leurs combinaisons)","Direction Symbolique");
		unités_direction.add(radians);
		unités_direction.add(degrés);
		unités_direction.add(direction_symbolique);
		/* UNITÉS DE DIRECTIONS : FIN */
		/* UNITÉS DE VITESSE : DÉBUT */
		/* UNITÉS DE VITESSE : FIN */
		/* UNITÉS D'HUMIDITÉ : DÉBUT */
		/* UNITÉS D'HUMIDITÉ : FIN */
		/* UNITÉS DE TEMPÉRATURE : DÉBUT */
		/* UNITÉS DE TEMPÉRATURE : FIN */
		/* UNITÉS DE PRESSION : DÉBUT */
		/* UNITÉS DE PRESSION : FIN */
		/* UNITÉS SUPLÉMENTAIRES : DÉBUT */
		/* UNITÉS SUPLÉMENTAIRES : FIN */
	};
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		create_units();
		sonde_random Random0_360=new sonde_random(10000L, 0, 360);
		new Thread((Runnable) Random0_360).start();
		Capteur_base capteur=new girouette(unités_direction, "girouette", Random0_360);
		System.out.println(capteur);
	}

}
