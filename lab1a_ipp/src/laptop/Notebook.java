package laptop;

public class Notebook extends Laptop implements INotebook{
	public Notebook () {
		
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
		Laptop laptop = new AdvancedNotebook();
		return laptop;
	}

	@Override
	public Laptop getBasic() {
		Laptop laptop = new BasicNotebook();
		return laptop;
	}
}
