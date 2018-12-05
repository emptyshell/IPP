package customization;

public class Backlight {
	private boolean value = false;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	//constructor
	public Backlight() {
		
	}
	
	public Backlight(boolean value) {
		this.setValue(value);
	}
}
