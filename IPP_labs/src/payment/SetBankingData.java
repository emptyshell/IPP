package payment;

import java.util.Scanner;

public class SetBankingData extends PaymentState {
	private BankingData bData = new BankingData();
 	public void setNext(int state) {
		Scanner s = new Scanner(System.in);
		System.out.println("Banking account: ");
		bData.setbAccount(s.nextLine());
		System.out.println("Routing number: ");
		bData.setrNumber(s.nextLine());
		DataObserver.getInstance().update(bData);
		state++;
		PaymentState.getInstance().setNext(state);
	}
}
