package Meteo;

import java.util.ArrayList;

public class Launcher {
	static numeric_unit radians;
	static numeric_unit_derived degr�s;
	static symbolic_unit direction_symbolique;
	static ArrayList<unit>  unit�s_direction=new ArrayList<unit>(3);
	static numeric_unit KmH;
	static numeric_unit_derived mS;
	static numeric_unit_derived MH;
	static numeric_unit_derived noeud;
	static symbolic_unit Beaufort;
	static symbolic_unit Bdescriptif;
	static symbolic_unit Bremarques;
	static ArrayList<unit>  unit�s_vitesses=new ArrayList<unit>(7);
	static numeric_unit humidit�;
	static ArrayList<unit>  unit�s_humidit�=new ArrayList<unit>(1);
	static numeric_unit degr�sC;
	static numeric_unit_derived degr�sF;
	static numeric_unit_derived degr�sK;
	static ArrayList<unit>  unit�s_temp�ratures=new ArrayList<unit>(3);
	static numeric_unit hPa;
	static numeric_unit_derived mbars;
	static numeric_unit_derived mmHg;
	static numeric_unit_derived poHg;
	static ArrayList<unit>  unit�s_pressions=new ArrayList<unit>(3);
	private static void create_units(){
		/* UNIT�S DE DIRECTIONS : D�BUT */
		degr�s=new numeric_unit_derived("� (Degr�s)", 0,
				0, 57.29578F, "Unit� : Degr�s. Repr�sentent l'angle math�matique (de 0 � 360)");
		radians=new numeric_unit("Radians", 2,
				"Unit� : Radians. Repr�sentent l'angle math�matique (de 0 � 2*Pi = 6,2832)");
		float[] direction_extr�mes={0.3927F,1.1781F,1.9635F,2.7489F,3.5343F,4.3197F,5.1051F,5.8905F,6.2832F};
		String[] direction_symboles={"Nord","Nord-Est","Est","Sud-Est","Sud","Sud-Ouest","Ouest","Nord-Ouest","Nord"};
		direction_symbolique=new symbolic_unit(direction_extr�mes, direction_symboles,
				"Unit� : Direction symbolique. Repr�sente les directions de la boussole (Nord, Sud, Est, Ouest et leurs combinaisons)","Direction Symbolique");
		unit�s_direction.add(radians);
		unit�s_direction.add(degr�s);
		unit�s_direction.add(direction_symbolique);
		/* UNIT�S DE DIRECTIONS : FIN */
		/* UNIT�S DE VITESSE : D�BUT */
		KmH=new numeric_unit("Km/h", 0,"Unit� : Kilom�tres par heure. Repr�sente la vitesse du vent (minimum : 0)");
		mS=new numeric_unit_derived("m/s", 0, 0, 0.2778F, "Unit� : m�tres par seconde. Repr�sente la vitesse du vent (minimum : 0)");
		MH=new numeric_unit_derived("M/h", 0, 0, 0.621371F, "Unit� : Miles par heure. Repr�sente la vitesse du vent (minimum : 0)");
		noeud=new numeric_unit_derived("noeuds", 0, 0, 0.539613F, "Unit� : noeuds. Repr�sente la vitesse du vent (minimum : 0)");
		float[] Beaufort_extr�mes={1F, 6F, 12F, 20F, 29F, 39F, 50F, 62F, 75F, 88F, 103F, 118F};
		String[] Beaufort_symboles={"0","1","2","3","4","5","6","7","8","9","10","11","12"};
		Beaufort=new symbolic_unit(Beaufort_extr�mes, Beaufort_symboles, "Unit� : derg� Beaufort. Repr�sente la vitesse du vent (de 0 � 12)", "degr� Beaufort");
		String[] Bdescriptif_symboles={"Calme","Tr�s l�g�re brise","L�g�re brise","Petite brise","Jolie brise","Bonne brise","vent frais","Grand frais","Coup de vent","Fort coup de vent","Temp�te","Violente temp�te","Ouragan"};
		Bdescriptif=new symbolic_unit(Beaufort_extr�mes,Bdescriptif_symboles,"Unit� : descriptif. Repr�sente le descriptif de la vitesse du vent","Descriptif");
		String [] Bremarques_symboles={"la fum�e s'�l�ve verticalement ; la mer est comme un miroir","il se forme des rides, mais il n'y a pas d'�cume","vaguelettes courtes ; leurs cr�tes ne d�ferlent pas","tr�s petites vagues ; �cume d'aspect vitreux","petites vagues devenant plus longues ; moutons nombreux","des lames se forment ; cr�tes d'�cume blanche plus �tendues","la mer grossit ; l'�cume est souffl�e en train�es ; lames d�ferlantes","lames de hauteur moyenne ; leurs cr�tes se d�tachent des tourbillons d'embruns","grosses lames ; leur cr�te s'�croule et d�ferle en rouleaux","tr�s grosses lames � longues cr�tes en panache ; d�ferlement en rouleau intense et brutal","lames exceptionnellement hautes ; mer recouverte de bancs d'�cume blanche","air plein d'�cume et d'embruns ; mer enti�rement blanche ; visibilit� tr�s r�duite"};
		Bremarques=new symbolic_unit(Beaufort_extr�mes,Bremarques_symboles,"Unit� : remarques. Repr�sente les remarques sur ce qui se passe en mer avec la vitesse du vent","remarques");
		unit�s_vitesses.add(KmH);
		unit�s_vitesses.add(mS);
		unit�s_vitesses.add(MH);
		unit�s_vitesses.add(noeud);
		unit�s_vitesses.add(Beaufort);
		unit�s_vitesses.add(Bdescriptif);
		unit�s_vitesses.add(Bremarques);
		/* UNIT�S DE VITESSE : FIN */
		/* UNIT� D'HUMIDIT� : D�BUT */
		humidit�=new numeric_unit("%", 1, "Unit� : pourcentage d'humidit�. Repr�sente le taux d'humidit� (de 0 � 100)");
		unit�s_humidit�.add(humidit�);
		/* UNIT� D'HUMIDIT� : FIN */
		/* UNIT�S DE TEMP�RATURE : D�BUT */
		degr�sC=new numeric_unit("�C", 0, "Unit� : degr�s Celsius. Repr�sente la temp�rature (minimum : -273.15)");
		degr�sF=new numeric_unit_derived("�F", 0, 32F, 1.8F, "Unit� : degr�s Fahrenheit. Repr�sente la temp�rature (minimum : -459.67)");
		degr�sK=new numeric_unit_derived("�K", 0, -273.15F, 1F, "Unit� : degr�s Kelvin. Repr�sente la temp�rature (minimum : 0)");
		unit�s_temp�ratures.add(degr�sC);
		unit�s_temp�ratures.add(degr�sF);
		unit�s_temp�ratures.add(degr�sK);
		/* UNIT�S DE TEMP�RATURE : FIN */
		/* UNIT�S DE PRESSION : D�BUT */
		hPa=new numeric_unit("hPa", 0, "Unit� : hectopascals. Repr�sente la pression (minimum :0)");
		mbars=new numeric_unit_derived("mbars", 0, 0, 1F, "Unit� : millibars. Repr�sente la pression (minimum : 0)");
		mmHg=new numeric_unit_derived("mm Hg", 0, 0, 0.75F, "Unit� : millim�tres de mercure. Repr�sente la pression (minimum : 0)");
		poHg=new numeric_unit_derived("po Hg", 0, 0, 0.033865F, "Unit� : pouces de mercure. Repr�sente la pression (minimum : 0)");
		unit�s_pressions.add(hPa);
		unit�s_pressions.add(mbars);
		unit�s_pressions.add(mmHg);
		unit�s_pressions.add(poHg);
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
