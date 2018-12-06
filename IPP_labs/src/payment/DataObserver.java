package payment;

public class DataObserver {
	private static DataObserver instance;
	private Payment p = new Payment();
	
	public Payment setData (BankingData bData, PersonalData pData, Amount amount) {
		p.setData(bData, pData, amount);
		return p;
	}
	
	public Payment update(Object obj) {

		if (obj instanceof BankingData ) {
			p.setbData((BankingData) obj);
		}
		else if (obj instanceof PersonalData) {
			p.setpData((PersonalData) obj);
		}
		else if(obj instanceof Amount) {
			p.setAmount((Amount) obj);
		}
		return p;
	}

	public static DataObserver getInstance() {
		if(instance == null) 
			instance = new DataObserver();
		return instance;
	}

	public static void setInstance(DataObserver instance) {
		DataObserver.instance = instance;
	}
	
	public Payment getPayment () {
		return p;
	}
}
