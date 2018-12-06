package techshop;
/*TODO
 * modyfy array to product laptop
 * modyfy coresponding methods
 */
import java.util.ArrayList;

import laptop.Laptop;

public class Warehouse  {
	private long capacity = 8;
	private ArrayList<Laptop> laptopArray = new ArrayList<Laptop>((int)capacity);
	private long stored = 0;
	private static Warehouse instance;
	
	public ArrayList<Laptop> getWarehouseContent() {
		return laptopArray;
	}
	public void setLaptopArray(ArrayList<Laptop> laptopArray) {
		this.laptopArray = laptopArray;
	}
	
	public Boolean addItem (Laptop newItem) {
		if (!this.getWarehouseContent().isEmpty()) {
			if(this.getWarehouseContent().get((int) stored-1).equals(newItem)) {
				this.getWarehouseContent().add((int) stored,newItem);
				stored+=1;
				return true;
			}
		}
		else {
			this.getWarehouseContent().add((int) stored,newItem);
			stored+=1;
			return true;
		}
		return false;	
	}
	
	public Laptop aquire(String lType) {
		for(Laptop ord: Warehouse.getInstance().getWarehouseContent()) {
			if(ord.getLaptopType().toLowerCase().equals(lType.toLowerCase()))
				return ord;
		}
		return null;
	}
	
	public Boolean release(Laptop oldItem) {
		if(this.getWarehouseContent().remove(oldItem))
			return true;
		return false;	
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public static Warehouse getInstance() {
		if(instance == null) 
			instance = new Warehouse();
		return instance;
	}
	public void setInstance(Warehouse instance) {
		Warehouse.instance = instance;
	}
	
	public Boolean ckAvailable(String laptopType) {
		Boolean tmp = false;
		for(Laptop a: laptopArray) {
			if(a.getLaptopType().toLowerCase().equals(laptopType.toLowerCase()))
				tmp = true;
		}
		return tmp;
	}
}
