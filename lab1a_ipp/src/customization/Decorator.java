package customization;

public class Decorator implements Apeareance{
	private String laptopApearence = "";
	private Backlight backlight = new Backlight();
	private Webcam webcam = new Webcam();
	private Fingerprint fingerprint = new Fingerprint();
	private Touchscreen touchscreen = new Touchscreen();
	//apearence interface 
	@Override
	public void setApearence(boolean webcam, boolean backlight, boolean fingerprint, boolean touchscreen) {
		if (webcam && !this.getLaptopApearence().contains("webcam")) {
			this.setLaptopApearence("webcam");
			this.getWebcam().setValue(true);
		}
		if (backlight && !this.getLaptopApearence().contains("backlight")) {
			this.setLaptopApearence("backlight");
			this.getBacklight().setValue(true);
		}
		if (fingerprint && !this.getLaptopApearence().contains("fingerprint")) {
			this.setLaptopApearence("fingerprint");
			this.getFingerprint().setValue(true);
		}
		if (touchscreen && !this.getLaptopApearence().contains("touchscreen")) {
			this.setLaptopApearence("touchscreen");
			this.getTouchscreen().setValue(true);
		}
	}
	//getters and setters
	public String getLaptopApearence() {
		return laptopApearence;
	}

	public void setLaptopApearence(String laptopApearence) {
		if (this.getLaptopApearence().equals("")) this.laptopApearence = laptopApearence;
		else this.laptopApearence += ", "+laptopApearence;
	}

	public Backlight getBacklight() {
		return backlight;
	}

	public void setBacklight(boolean backlight) {
		this.backlight.setValue(backlight);
	}

	public Webcam getWebcam() {
		return webcam;
	}

	public void setWebcam(boolean webcam) {
		this.webcam.setValue(webcam);
	}

	public Fingerprint getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(boolean fingerprint) {
		this.fingerprint.setValue(fingerprint);
	}

	public Touchscreen getTouchscreen() {
		return touchscreen;
	}

	public void setTouchscreen(boolean touchscreen) {
		this.touchscreen.setValue(touchscreen);
	}
	
}
