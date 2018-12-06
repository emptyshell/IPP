package laptop;


public class Netbook extends Laptop implements INetbook{
	
	public Netbook () {
		
	}
	
	public Laptop orderNewLaptop(String laptopType) {
		Laptop laptop;
		if (laptopType.contains("Advanced") || laptopType.contains("advanced")) {
			laptop = getAdvanced();
			return laptop;
		}
		else if (laptopType.contains("Basic") || laptopType.contains("basic")) {
			laptop = getBasic();
			return laptop;
		}
		else {
			return null;
		}
	}
	
	@Override
	public Laptop getAdvanced() {
		Laptop laptop = new AdvancedNetbook();
		return laptop;
	}

	@Override
	public Laptop getBasic() {
		Laptop laptop = new BasicNetbook();
		return laptop;
	}
}
