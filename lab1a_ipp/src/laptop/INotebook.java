package laptop;

public interface INotebook {
	public Laptop orderNewLaptop(String laptopType);
	public Laptop getBasic();
	public Laptop getAdvanced();
}
