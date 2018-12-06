package payment;

import java.util.Scanner;

public class PaymentHandler {
	private int currentState = 1;
	//private Payment payment = new Payment();
	private Scanner s;
	
	public void handlePayment() {
		//choose payment method
		
		System.out.print("\n1.Mastercard"
				+ "\n2.VISA"
				+ "\n3.Paypal"
				+ "\nChoose payment method: \n");
		s = new Scanner(System.in);
		int n = s.nextInt();
		
		switch(n) {
		case 1:
			MethodOne o = new MethodOne(Receiver.getInstance(),1);
			o.execute();
			break;
		case 2:
			MethodTwo tw = new MethodTwo(Receiver.getInstance(),1);
			tw.execute();
			break;
		case 3:
			MethodThree th = new MethodThree(Receiver.getInstance(),2);
			th.execute();
		}
		
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
}
