package Sonde;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Capteur.AbstractCapteur;
import Capteur.Capteur;

public class Sonde_fichier extends AbstractSonde {

	/**
	 * @uml.property name="delai"
	 */
	private int delai;

	/**
	 * Getter of the property <tt>delai</tt>
	 * 
	 * @return Returns the delai.
	 * @uml.property name="delai"
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * Setter of the property <tt>delai</tt>
	 * 
	 * @param delai
	 *            The delai to set.
	 * @uml.property name="delai"
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	private class MiseaJour implements Runnable {
		private File f;
		private Scanner scan;
		private String file;

		public MiseaJour(String fich) {
			f = new File(fich);
			this.file = fich;
			try {
				scan = new Scanner(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			try {
				Thread.sleep(1000 * delai);
				if (scan.hasNextLine()) {
					String line = scan.nextLine();
					float val = Float.parseFloat(line);
					setValeur(val);
					notifyObservers(val);
				} else {
					f = new File(file);
					try {
						scan = new Scanner(f);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String line = scan.nextLine();
					float val = Float.parseFloat(line);
					setValeur(val);
					notifyObservers(val);
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public Sonde_fichier(String s) {
		delai = 1;
		MiseaJour miseajour = new MiseaJour(s);
		Thread t = new Thread(miseajour);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Sonde_fichier(String s, Capteur c) {
		delai = 1;
		this.addObserver(c);
		MiseaJour miseajour = new MiseaJour(s);
		Thread t = new Thread(miseajour);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Sonde_fichier(int d, String s) {
		delai = d;
		MiseaJour miseajour = new MiseaJour(s);
		Thread t = new Thread(miseajour);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registerCapteur(AbstractCapteur obs) {

	}

}
