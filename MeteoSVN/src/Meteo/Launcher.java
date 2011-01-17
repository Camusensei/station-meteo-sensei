package Meteo;

import java.util.ArrayList;

public class Launcher {
	static numeric_unit radians;
	static numeric_unit_derived degrés;
	static symbolic_unit direction_symbolique;
	static ArrayList<unit>  unités_direction=new ArrayList<unit>(3);
	static numeric_unit KmH;
	static numeric_unit_derived mS;
	static numeric_unit_derived MH;
	static numeric_unit_derived noeud;
	static symbolic_unit Beaufort;
	static symbolic_unit Bdescriptif;
	static symbolic_unit Bremarques;
	static ArrayList<unit>  unités_vitesses=new ArrayList<unit>(7);
	static numeric_unit humidité;
	static ArrayList<unit>  unités_humidité=new ArrayList<unit>(1);
	static numeric_unit degrésC;
	static numeric_unit_derived degrésF;
	static numeric_unit_derived degrésK;
	static ArrayList<unit>  unités_températures=new ArrayList<unit>(3);
	static numeric_unit hPa;
	static numeric_unit_derived mbars;
	static numeric_unit_derived mmHg;
	static numeric_unit_derived poHg;
	static ArrayList<unit>  unités_pressions=new ArrayList<unit>(3);
	private static void create_units(){
		/* UNITÉS DE DIRECTIONS : DÉBUT */
		degrés=new numeric_unit_derived("° (Degrés)", 0,
				0, 57.29578F, "Unité : Degrés. Représentent l'angle mathématique (de 0 à 360)");
		radians=new numeric_unit("Radians", 2,
				"Unité : Radians. Représentent l'angle mathématique (de 0 à 2*Pi = 6,2832)");
		float[] direction_extrèmes={0.3927F,1.1781F,1.9635F,2.7489F,3.5343F,4.3197F,5.1051F,5.8905F,6.2832F};
		String[] direction_symboles={"Nord","Nord-Est","Est","Sud-Est","Sud","Sud-Ouest","Ouest","Nord-Ouest","Nord"};
		direction_symbolique=new symbolic_unit(direction_extrèmes, direction_symboles,
				"Unité : Direction symbolique. Représente les directions de la boussole (Nord, Sud, Est, Ouest et leurs combinaisons)","Direction Symbolique");
		unités_direction.add(radians);
		unités_direction.add(degrés);
		unités_direction.add(direction_symbolique);
		/* UNITÉS DE DIRECTIONS : FIN */
		/* UNITÉS DE VITESSE : DÉBUT */
		KmH=new numeric_unit("Km/h", 0,"Unité : Kilomètres par heure. Représente la vitesse du vent (minimum : 0)");
		mS=new numeric_unit_derived("m/s", 0, 0, 0.2778F, "Unité : mètres par seconde. Représente la vitesse du vent (minimum : 0)");
		MH=new numeric_unit_derived("M/h", 0, 0, 0.621371F, "Unité : Miles par heure. Représente la vitesse du vent (minimum : 0)");
		noeud=new numeric_unit_derived("noeuds", 0, 0, 0.539613F, "Unité : noeuds. Représente la vitesse du vent (minimum : 0)");
		float[] Beaufort_extrèmes={1F, 6F, 12F, 20F, 29F, 39F, 50F, 62F, 75F, 88F, 103F, 118F};
		String[] Beaufort_symboles={"0","1","2","3","4","5","6","7","8","9","10","11","12"};
		Beaufort=new symbolic_unit(Beaufort_extrèmes, Beaufort_symboles, "Unité : dergé Beaufort. Représente la vitesse du vent (de 0 à 12)", "degré Beaufort");
		String[] Bdescriptif_symboles={"Calme","Très légère brise","Légère brise","Petite brise","Jolie brise","Bonne brise","vent frais","Grand frais","Coup de vent","Fort coup de vent","Tempête","Violente tempête","Ouragan"};
		Bdescriptif=new symbolic_unit(Beaufort_extrèmes,Bdescriptif_symboles,"Unité : descriptif. Représente le descriptif de la vitesse du vent","Descriptif");
		String [] Bremarques_symboles={"la fumée s'élève verticalement ; la mer est comme un miroir","il se forme des rides, mais il n'y a pas d'écume","vaguelettes courtes ; leurs crêtes ne déferlent pas","très petites vagues ; écume d'aspect vitreux","petites vagues devenant plus longues ; moutons nombreux","des lames se forment ; crêtes d'écume blanche plus étendues","la mer grossit ; l'écume est soufflée en trainées ; lames déferlantes","lames de hauteur moyenne ; leurs crêtes se détachent des tourbillons d'embruns","grosses lames ; leur crête s'écroule et déferle en rouleaux","très grosses lames à longues crêtes en panache ; déferlement en rouleau intense et brutal","lames exceptionnellement hautes ; mer recouverte de bancs d'écume blanche","air plein d'écume et d'embruns ; mer entièrement blanche ; visibilité très réduite"};
		Bremarques=new symbolic_unit(Beaufort_extrèmes,Bremarques_symboles,"Unité : remarques. Représente les remarques sur ce qui se passe en mer avec la vitesse du vent","remarques");
		unités_vitesses.add(KmH);
		unités_vitesses.add(mS);
		unités_vitesses.add(MH);
		unités_vitesses.add(noeud);
		unités_vitesses.add(Beaufort);
		unités_vitesses.add(Bdescriptif);
		unités_vitesses.add(Bremarques);
		/* UNITÉS DE VITESSE : FIN */
		/* UNITÉ D'HUMIDITÉ : DÉBUT */
		humidité=new numeric_unit("%", 1, "Unité : pourcentage d'humidité. Représente le taux d'humidité (de 0 à 100)");
		unités_humidité.add(humidité);
		/* UNITÉ D'HUMIDITÉ : FIN */
		/* UNITÉS DE TEMPÉRATURE : DÉBUT */
		degrésC=new numeric_unit("°C", 0, "Unité : degrés Celsius. Représente la température (minimum : -273.15)");
		degrésF=new numeric_unit_derived("°F", 0, 32F, 1.8F, "Unité : degrés Fahrenheit. Représente la température (minimum : -459.67)");
		degrésK=new numeric_unit_derived("°K", 0, -273.15F, 1F, "Unité : degrés Kelvin. Représente la température (minimum : 0)");
		unités_températures.add(degrésC);
		unités_températures.add(degrésF);
		unités_températures.add(degrésK);
		/* UNITÉS DE TEMPÉRATURE : FIN */
		/* UNITÉS DE PRESSION : DÉBUT */
		hPa=new numeric_unit("hPa", 0, "Unité : hectopascals. Représente la pression (minimum :0)");
		mbars=new numeric_unit_derived("mbars", 0, 0, 1F, "Unité : millibars. Représente la pression (minimum : 0)");
		mmHg=new numeric_unit_derived("mm Hg", 0, 0, 0.75F, "Unité : millimètres de mercure. Représente la pression (minimum : 0)");
		poHg=new numeric_unit_derived("po Hg", 0, 0, 0.033865F, "Unité : pouces de mercure. Représente la pression (minimum : 0)");
		unités_pressions.add(hPa);
		unités_pressions.add(mbars);
		unités_pressions.add(mmHg);
		unités_pressions.add(poHg);
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
