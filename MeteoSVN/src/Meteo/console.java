package Meteo;

import java.io.IOException;

public class console implements Runnable {

	private int val;
	
	@Override
	public synchronized void run() {
		while(true){
			System.out.println(Capteur_base.capteurs);
				try {
					val=System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				if (val==113){
					System.exit(0);
				}
						
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		}
	}

}
