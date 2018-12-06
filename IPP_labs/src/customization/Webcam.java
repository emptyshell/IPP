package customization;

public class Webcam {
	private boolean value = false;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	//constructor
	public Webcam() {
		
	}
	
	public Webcam(boolean value) {
		this.setValue(value);
	}
}
