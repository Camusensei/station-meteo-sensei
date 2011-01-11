package Meteo;


public class symbolic_unit extends unit {
		public symbolic_unit(float[] tableau_min, float[] tabelau_max, String[] tablea_valeur, String description){
		}

		/**
		 * @uml.property  name="tab_min" multiplicity="(0 -1)" dimension="1"
		 */
		public float[] tab_mins;
		/**
		 * @uml.property  name="tab_max" multiplicity="(0 -1)" dimension="1"
		 */
		public float[] tab_maxs;
		/**
		 * @uml.property  name="tab_val" multiplicity="(0 -1)" dimension="1"
		 */
		public String[] tab_vals;
		@Override
		public String getFormattedValue(float valeur) throws Exception {
			int i,length;
			if((length=tab_mins.length)!=tab_maxs.length || length!=tab_vals.length) throw new Exception("les tableaux sont de taille différentes !");
			for (i=0;i<length;i++) {
				if (valeur>=tab_mins[i]&&valeur<=tab_maxs[i]) return tab_vals[i];
				}
			return Description;
		}
}
