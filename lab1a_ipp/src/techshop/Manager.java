package techshop;

import laptop.CustomLaptop;
import laptop.Gamebook;
import laptop.Laptop;
import laptop.Netbook;
import laptop.Notebook;
import laptop.Ultrabook;

public class Manager extends Laptop implements BuildLaptop {
	private Laptop laptop;
	public Manager(String laptopType) {
		setLaptop(this.orderNewLaptop(laptopType));
	}
	
	public Laptop orderNewLaptop(String laptopType) {
		if(laptopType.toLowerCase().contains("netbook")) {
			Netbook netBook = new Netbook();
			laptop = netBook.orderNewLaptop(laptopType);
			return laptop;
		}
		else if (laptopType.toLowerCase().contains("gamebook")) {
			Gamebook gameBook = new Gamebook();
			laptop = gameBook.orderNewLaptop(laptopType);
			return laptop;
		}
		else if (laptopType.contains("Ultrabook") || laptopType.contains("ultrabook")) {
			Ultrabook ultraBook = new Ultrabook();
			laptop = (Laptop) ultraBook.orderNewLaptop(laptopType);
			return laptop;
		}
		else if (laptopType.contains("Notebook") || laptopType.contains("notebook")) {
			Notebook noteBook = new Notebook();
			laptop = noteBook.orderNewLaptop(laptopType);
			return laptop;
		}
		else
		laptop = new CustomLaptop();
		return laptop;
	}
	@Override
	public void setScreenSize(int size) {
		this.screenSize = size;
	}
	@Override
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	@Override
	public void setGraphicsType(String graphicsType) {
		this.graphicType = graphicsType;
	}
	@Override
	public void setGraphicsCard(String graphicsCard) {
		this.graphicCard = graphicsCard;
	}
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public void setScreenSize(long size) {
		this.screenSize = (int) size;
		
	}

	@Override
	public void setPrice(long price) {
		this.price = price;
	}

}
