package payment;

import java.util.Scanner;

public class SetAmount extends PaymentState {
		Amount amount = new Amount();
	public void setNext(int state) {
		Scanner s = new Scanner(System.in);
		System.out.println("Amount to pay: ");
		amount.setAmount(s.nextLong());
		DataObserver.getInstance().update(amount);
		state++;
		PaymentState.getInstance().setNext(state);
	}
	
}
