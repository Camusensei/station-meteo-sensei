package Meteo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class sonde_fichier_serveur extends sonde {

	public sonde_fichier_serveur(long time_ms, String fichier) {
		super(time_ms);
		this.fichier = fichier;
	}

	/**
	 * @uml.property name="fichier"
	 */
	private String fichier;

	@Override
	public void setData() {
		try {
			float f;
			// create FileInputStream object
			FileInputStream fin = new FileInputStream(fichier);
			/*
			 * To create DataInputStream object, use DataInputStream(InputStream
			 * in) constructor.
			 */
			DataInputStream din = new DataInputStream(fin);
			/*
			 * To read a Java float primitive from file, use byte readFloat()
			 * method of Java DataInputStream class.
			 * 
			 * This method reads 4 bytes and returns it as a float value.
			 */
			f = din.readFloat();
			/*
			 * To close DataInputStream, use void close() method.
			 */
			din.close();
			super.change(f);
		} catch (FileNotFoundException fe) {
			System.out.println("FileNotFoundException : " + fe);
		} catch (IOException ioe) {
			System.out.println("IOException : " + ioe);
		}
	}
}
