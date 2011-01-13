package Meteo;

import java.util.Observable;

public class sonde implements Runnable {

	public sonde (){
		super();
		obs=new Observable();
	}
	
	protected Observable obs;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread sonde = new Thread();
	}
	
}
