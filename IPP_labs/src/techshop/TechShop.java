package techshop;

import java.util.ArrayList;
import java.util.Scanner;

import mailbox.Adaptor;
import payment.Payment;
import payment.PaymentHandler;

public class TechShop implements ITechShop,LastProductRequest,SameProductRequest {
	private static Order newOrder = new Order();
	private static Order lastOrder = null;
	private static Scanner scan;
	private static Adaptor adaptor = new Adaptor();
	
	public static void main (String argv[]) {
		boolean run=true;
		while(run) {
		System.out.print("\n\nWelcome to the TECHSHOP!!!\n"
				+ "1.Read orders from mailbox\n"
				+ "2.Make new purchease\n"
				+ "3.Make Payment\n"
				+ "4.Exit\n"
				+ "\nEnter your option: ");
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		switch(n) {
		case 1:
			readMailbox();
			break;
		case  2:
			newPurchase();
			break;
		case 3:
			makePayment(newOrder);
		case 4:
			run = false;
			break;
			default:
				System.out.println("Wrong choise! Try again!");
		}
		
		
		}
	}
	
	
	public static Boolean compareWithLastProduct(Order lastOrder,String laptopType) {
		if(lastOrder.getProduct().getLaptopType().equalsIgnoreCase(laptopType)) {
			return true;
		}
		return false;
	}

	
	public static Order cloneLastOrder(String cliName) {
		newOrder = getLastOrder();
		getNewOrder().setClientName(cliName);
		return getNewOrder();
	}

	public static Order getNewOrder() {
		return newOrder;
	}


	public static Order getLastOrder() {
		return lastOrder;
	}
	
	public static String basicOrAdvanced(String baseType) {
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("\n1.Basic\n2.Advanced\nChoose build: \n");
			int subType = scan.nextInt();
			switch(subType) {
			case 1:
				return "basic"+baseType;
			case 2:
				return "advanced"+baseType;
				default:
					System.out.println("Wrong! Try again!");
				
			}
		}
		
	}
	
	public static void newPurchase() {
		System.out.println("Client name: \n");
		String cliName = scan.nextLine();
		cliName = scan.nextLine();
		//System.out.println("Laptop type: ");
		String laptopType = "";//= scan.nextLine();
		String baseType;
		while(true) {
			System.out.print("\n1.Notebook\n2.Netbook\n3.Gamebook\n4.Ultrabook\n5.Custom\nChoose your type: \n");
			int mType = scan.nextInt();
			switch (mType) {
			case 1:
				baseType = "Notebook";
				laptopType = basicOrAdvanced(baseType);
				break;
			case 2:
				baseType = "Netbook";
				laptopType = basicOrAdvanced(baseType);
				break;
			case 3:
				baseType = "Gamebook";
				laptopType = basicOrAdvanced(baseType);
				break;
			case 4:
				baseType = "Ultrabook";
				laptopType = basicOrAdvanced(baseType);
				break;
			case 5:
				laptopType = "custom";
				break;
				default:
					System.out.println("Wrong! Try again!");
			
			}
			if(!laptopType.equals(""))
				break;
		}
		if(lastOrder == null) {
			getNewOrder().setProduct(getNewOrder().getNewProduct(laptopType));
			getNewOrder().setClientName(cliName);
			getNewOrder().decorateProduct();
			getNewOrder().setColor();
			lastOrder = getNewOrder();
		}
		
		else if(compareWithLastProduct(lastOrder, laptopType)) {
			newOrder = cloneLastOrder(cliName);
			getNewOrder().decorateProduct();
			getNewOrder().setColor();
			lastOrder = getNewOrder();
		}
			
		else {
			//Manager laptop = new Manager(laptopType);
			getNewOrder().setProduct(getNewOrder().getNewProduct(laptopType));
			getNewOrder().setClientName(cliName);
			getNewOrder().decorateProduct();
			getNewOrder().setColor();
			lastOrder = getNewOrder();
		}
		
		if(getNewOrder() != null) {
			System.out.println("\n"+getNewOrder().getClientName());
			getNewOrder().getProduct().showLaptopData();
			System.out.println("\nColor: " + getNewOrder().getColor().getpColor());
			System.out.println("Customization: " + getNewOrder().getDecorator().getLaptopApearence());
		}

	}
	
	public static void readMailbox() {
		System.out.println("Your Emailed orders: ");
		adaptor.xml2oreder();
		ArrayList<Order> orderList = adaptor.getOrderList();
		for(int i=0; i<orderList.size(); i++) {
			System.out.println("\n"+orderList.get(i).getClientName());
			orderList.get(i).getProduct().showLaptopData();
			System.out.println("\nColor: " + orderList.get(i).getColor().getpColor());
			System.out.println("Customization: " + orderList.get(i).getDecorator().getLaptopApearence());
		}
		
	}
	
	public static void makePayment(Order o) {
		PaymentHandler pHandler = new PaymentHandler();
		pHandler.handlePayment();
	}
}
