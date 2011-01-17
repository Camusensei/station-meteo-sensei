package Meteo;

import java.io.IOException;
import Meteo.Preparation;

public class console {

	public static void main(String[] args) throws Exception {
		Preparation.create_units();
		run();
	}

	public static void run() {
		int val;
		while (true) {
			System.out.println(Capteur_base.count_observers());
			System.out.println(Capteur_base.capteurs);
			try {
				val = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			System.out
					.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			if (val == 113) {
				System.exit(0);
			}

			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		}
	}

}
