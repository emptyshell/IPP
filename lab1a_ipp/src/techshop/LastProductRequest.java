package techshop;

public interface LastProductRequest {
	public static Boolean compareWithLastProduct(Order lastOrder, String laptopType) {
		if(lastOrder.getProduct().getLaptopType().equalsIgnoreCase(laptopType)) {
			return true;
		}
		return false;
	}

}
