package techshop;

import laptop.Laptop;

public interface BuildLaptop {
	public Laptop orderNewLaptop (String laptopType);
	public void setScreenSize(long size);
	public void setCpu(String cpu);
	public void setGraphicsType(String graphicsType);
	public void setGraphicsCard(String graphicsCard);
	public void setPrice(long price);
}
