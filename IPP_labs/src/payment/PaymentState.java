package payment;

public class PaymentState {
	private static PaymentState instance;
	
	public void setNext(int state) {
		switch(state) {
		case 1:
			SetBankingData b = new SetBankingData();
			b.setNext(state);
			break;
		case 2:
			SetPersonal p = new SetPersonal();
			p.setNext(state);
			break;
		case 3:
			SetAmount a = new SetAmount();
			a.setNext(state);
			break;
		}
	}

	public static PaymentState getInstance() {
		if(instance == null) 
			instance = new PaymentState();
		return instance;
	}

	public void setInstance(PaymentState instance) {
		this.instance = instance;
	}
}
