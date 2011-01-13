package Meteo;


public class symbolic_unit extends unit {
		public symbolic_unit(float[] tab_extrèmes, String[] tableau_valeurs, String description, String symbol){
			super(description, symbol);
		}

		/**
		 * @uml.property  name="tab_extrèmes" multiplicity="(0 -1)" dimension="1"
		 */
		public float[] tab_extrèmes;
		/**
		 * @uml.property  name="tab_valeurs" multiplicity="(0 -1)" dimension="1"
		 */
		public String[] tab_valeurs;
		@Override
		public String getFormattedValue(float valeur) throws Exception {
			int i,length;
			if((length=tab_valeurs.length)!=tab_extrèmes.length) throw new Exception("les tableaux sont de taille différentes !");
			for (i=0;i<length;i++) {
				if (valeur<=tab_extrèmes[i]) return tab_valeurs[i];
				}
			return tab_valeurs[length];
		}
}
