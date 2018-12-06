package payment;

import java.util.Scanner;

public class SetPersonal extends PaymentState {
	
	private PersonalData pData = new PersonalData();
	
	public void setNext(int state) {
		Scanner s = new Scanner(System.in);
		System.out.println("First name: ");
		pData.setfName(s.nextLine());
		System.out.println("Last name: ");
		pData.setlName(s.nextLine());
		System.out.println("Birthday date: ");
		pData.setbDate(s.nextLine());
		System.out.println("Address: ");
		pData.setAddress(s.nextLine());
		System.out.println("email: ");
		pData.setEmail(s.nextLine());
		DataObserver.getInstance().update(pData);
		state++;
		PaymentState.getInstance().setNext(state);
	}

	public PersonalData getpData() {
		return pData;
	}

	public void setpData(PersonalData pData) {
		this.pData = pData;
	}
	
}
