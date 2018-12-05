package techshop;

import java.util.ArrayList;
import java.util.Scanner;

import customization.Color;
import customization.Decorator;
import laptop.Laptop;

public class Order implements Flyweigth{
	private String clientName;
	private Laptop product;
	private Warehouse wHouse = Warehouse.getInstance();
	private Manager laptop;
	private Decorator decorator = new Decorator();
	private Color color = new Color();
	//getters and setters
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public Laptop getProduct() {
		return product;
	}
	
	public void setProduct(Laptop product) {
		this.product = product;
	}
	public Decorator getDecorator() {
		return this.decorator;
	}

	@Override
	public Laptop getNewProduct(String productType) {
		laptop = new Manager(productType);
		getColor().setPType(productType);
		if (this.checkWarehouse(productType)) {
			this.setProduct(laptop.getLaptop());
			return wHouse.aquire(productType);
		}
			if(wHouse.addItem(laptop.getLaptop()));
			this.setProduct(laptop.getLaptop());
			return laptop.getLaptop();
	}

	@Override
	public Boolean checkWarehouse(String productType) {
		return wHouse.ckAvailable(productType);
	}
	
	public void decorateProduct() {
		Scanner scanner = new Scanner(System.in);
		String t="";
		System.out.println("Backlight? [y/n]");
		t = scanner.nextLine();
		if (t.contains("y"))
			decorator.setBacklight(true);
		t = "n";
		System.out.println("Webcam? [y/n]");
		t = scanner.nextLine();
		if (t.contains("y"))
			decorator.setWebcam(true);
		t = "n";
		System.out.println("Fingerprint? [y/n]");
		t = scanner.nextLine();
		if (t.contains("y"))
			decorator.setFingerprint(true);
		t = "n";
		System.out.println("Touchscreen? [y/n]");
		t = scanner.nextLine();
		if (t.contains("y"))
			decorator.setTouchscreen(true);
		decorator.setApearence(
				decorator.getWebcam().isValue(), 
				decorator.getBacklight().isValue(),
				decorator.getFingerprint().isValue(),
				decorator.getTouchscreen().isValue()
				);
		//scanner.close();
		//System.out.println(decorator.getLaptopApearence());
	}

	public Color getColor() {
		return color;
	}

	public void setColor() {
		Scanner scan = new Scanner(System.in);
		int pTypeIndex = getColor().getIndexByPType(getColor().getPType());
		int i=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int j=0; j<getColor().getColorArray(pTypeIndex).length; j++) {
			if (getColor().getColorArray(pTypeIndex, j)) {
				list.add(j);
				i++;
				System.out.println(Integer.toString(i)+" "+getColor().getColorByColumn(j));
			}
		}
		System.out.println("what color would you like to choose: ");
		getColor().setpColor(getColor().getColorByColumn(list.get(scan.nextInt()-1)));
		//System.out.println(getColor().getpColor());
	}
	
	public void setColor(String color) {
		getColor().setpColor(color);
	}
	
}
