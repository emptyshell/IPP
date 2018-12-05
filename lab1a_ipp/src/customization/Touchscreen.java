package customization;

public class Touchscreen {
	private boolean value = false;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	//constructor
	public Touchscreen() {
		
	}
	
	public Touchscreen(boolean value) {
		this.setValue(value);
	}
}
