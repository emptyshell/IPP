package laptop;

import java.util.Scanner;

public class CustomLaptop extends Laptop implements ILaptop, techshop.BuildLaptop {
	private Scanner scan;

	public CustomLaptop() {
		scan = new Scanner(System.in);
		System.out.print("Choose screen size [10,12,14,15,17,19]: ");
		this.setScreenSize(scan.nextLong());
		System.out.print("Choose CPU model [Intel i3, Intel i5, Intel i7, Cortex A9, AMD A10, AMD FX]: ");
		this.setCpu(scan.nextLine());
		System.out.print("Choose RAM amount[1,2,4,8,16,32]: ");
		this.setRam(scan.nextLine());
		System.out.print("Choose Graphic Type [discret, integrated]: ");
		this.setGraphicType(scan.nextLine());
		System.out.print("Choose Graphic Card [Nvidia Geforce,AMD Radeon, Intel Graphics]: ");
		this.setGraphicCard(scan.nextLine());
		System.out.print("Laptop type: ");
		this.setLaptopType("Custom");
		System.out.print("Price: ");
		this.setPrice(scan.nextLong());
	}

	@Override
	public Laptop orderNewLaptop(String laptopType) {
		Laptop customLaptop = new CustomLaptop();
		return customLaptop;
	}
	@Override
	public void setScreenSize(long l) {
		//this.screenSize = size;
	}
	@Override
	public void setCpu(String cpu) {
		//this.cpu = cpu;
	}
	@Override
	public void setGraphicsType(String graphicsType) {
		//this.graphicType = graphicsType;
	}
	@Override
	public void setGraphicsCard(String graphicsCard) {
		//this.graphicCard = graphicsCard;
	}
	@Override
	public void setPrice(long l) {
		//this.price = price;
	}
}
