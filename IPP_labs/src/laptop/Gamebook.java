package laptop;

public class Gamebook extends Laptop implements IGamebook {
	public Gamebook () {
		
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
		Laptop laptop = new AdvancedGamebook();
		return laptop;
	}

	@Override
	public Laptop getBasic() {
		Laptop laptop = new BasicGamebook();
		return laptop;
	}
}
