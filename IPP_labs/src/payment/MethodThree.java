package payment;

public class MethodThree implements PaymentMethod {
	 	
	private int n =0;
	private Receiver r;
	private int currentState = 1;
	private String email = "";
	
	@Override
	public void execute() {
		PaymentState.getInstance().setNext(this.getN());
		email = DataObserver.getInstance().getPayment().getpData().getEmail();
		if (!email.equals(""))
		r.paypal(email);
		else
		System.out.println("No email data!");
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
		
		public MethodThree(Receiver r, int n) {
			this.setR(r);
			this.setN(n);
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
}
