package Meteo;

import java.util.Observable;

public class sonde extends Thread {

	public sonde (){
		super();
		obs=new Observable();
	}
	
	protected Observable obs;
	
}
