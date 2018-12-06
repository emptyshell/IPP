package laptop;

public class Laptop implements ILaptop {
	protected String cpu;
	private String ram;
	protected String graphicType;
	protected String graphicCard;
	protected long price;
	protected int screenSize;
	private String laptopType;
	
	public void showLaptopData() {
		System.out.print("\nLaptop type: "+getLaptopType()+"\nScreen size: "+Integer.toString(getScreenSize())+"\nCPU: "+getCpu()+"\nRAM: "+getRam()+"\nGraphics type: "+getGraphicType()+"\nGraphics card: "+getGraphicCard()+"\nPrice: "+Long.toString(getPrice()));
	}
	
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getGraphicType() {
		return graphicType;
	}
	public void setGraphicType(String graphicType) {
		this.graphicType = graphicType;
	}
	public String getGraphicCard() {
		return graphicCard;
	}
	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}
	
	
	
	public Laptop orderNewLaptop(String laptopType) {
		Laptop laptop ;
		if(laptopType.contains("Netbook") || laptopType.contains("netbook")) {
			Netbook netBook = new Netbook();
			laptop = netBook.orderNewLaptop(laptopType);
			return laptop;
		}
		else if (laptopType.contains("Gamebook") || laptopType.contains("gamebook")) {
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
	public String getLaptopType() {
		return laptopType;
	}
	public void setLaptopType(String laptopType) {
		this.laptopType = laptopType;
	}
	
	
	

}
