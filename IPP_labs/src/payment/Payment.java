package payment;

public class Payment {
	private PersonalData pData;
	private BankingData bData;
	private Amount amount;
	
	public void setData (BankingData bData, PersonalData pData, Amount amount) {
		
	}
	
	public Payment getData() {
		return this;
	}

	public PersonalData getpData() {
		return pData;
	}

	public void setpData(PersonalData pData) {
		this.pData = pData;
	}

	public BankingData getbData() {
		return bData;
	}

	public void setbData(BankingData bData) {
		this.bData = bData;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
}
