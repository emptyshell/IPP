package payment;

import java.util.Scanner;

public class Receiver {
	private static Receiver instance;
	
	public void paypal(String email) {
		System.out.print("\nCurrent email: "+email+"\nRerouting to paypal site.");
	}
	
	public void mastercard(BankingData bData) {
		System.out.print("Banking account: "+bData.getbAccount()+"\nRouting number: "+ bData.getrNumber()+"\nTransfer succesfully");
	}
	
	public void visa(BankingData bData) {
		System.out.print("Banking account: "+bData.getbAccount()+"\nRouting number: "+ bData.getrNumber()+"\nTransfer succesfully");
	}

	public void setInstance(Receiver r) {
		instance = r ;
	}

	public static Receiver getInstance() {
		if(instance == null) 
			instance = new Receiver();
		return instance;
	}
}
