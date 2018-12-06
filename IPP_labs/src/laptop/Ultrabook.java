package laptop;

public class Ultrabook extends Laptop implements IUltrabook{
	public Ultrabook () {
		
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
		Laptop laptop = new AdvancedUltrabook();
		return (Laptop) laptop;
	}

	@Override
	public Laptop getBasic() {
		Laptop laptop = new BasicUltrabook();
		return (Laptop) laptop;
	}
}
