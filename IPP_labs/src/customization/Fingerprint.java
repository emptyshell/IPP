package customization;

public class Fingerprint {
	private boolean value = false;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	//constructor
	public Fingerprint() {
		
	}
	
	public Fingerprint(boolean value) {
		this.setValue(value);
	}
}
