package payment;

public class MethodOne implements PaymentMethod {
	
	private int n =0;
	private Receiver r;
	private int currentState = 1;
	private BankingData bData = null;
	
	@Override
	public void execute() {
		PaymentState.getInstance().setNext(this.getN());
		bData = DataObserver.getInstance().getPayment().getbData();
		if (bData != null)
		r.mastercard(bData);
		else
		System.out.println("No banking data!");
	}
	
	public MethodOne(Receiver r, int n) {
		this.setR(r);
		this.setN(n);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Receiver getR() {
		return r;
	}

	public void setR(Receiver r) {
		this.r = r;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	
}
