package mailbox;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import techshop.Order;

public class Adaptor implements MailboxAdaptor {
	private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder dBuilder;
	private Mailbox mailbox = new Mailbox();
	private Document doc;
	private ArrayList<Order> orderList;
	
	
	
	@Override
	public ArrayList<Order> xml2oreder() {
		try {
			try {
				dBuilder = dbFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doc = dBuilder.parse(mailbox.getXmlList());
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("order");
			
			orderList = new ArrayList<Order>();
			for(int temp = 0;  temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType()== Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Order oOrder = new Order();
					//System.out.println(eElement.getElementsByTagName("laptop").item(0).getTextContent().toLowerCase());
					oOrder.getNewProduct(eElement.getElementsByTagName("laptop").item(0).getTextContent().toLowerCase());
					
					oOrder.setClientName(eElement.getElementsByTagName("client").item(0).getTextContent());
					oOrder.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
					boolean webcam = false,
							backlight = false,
							fingerprint = false,
							touchscreen = false;
					NodeList customList = eElement.getElementsByTagName("customization");
					for (int i = 0; i<customList.getLength(); i++) {
						Node nCustomNode = customList.item(i);
						if(nCustomNode.getNodeType() == Node.ELEMENT_NODE) {
							Element cusElement = (Element) nCustomNode;
							
							if(cusElement.getElementsByTagName("w").item(0) != null)
							if (cusElement.getElementsByTagName("w").item(0).getTextContent().toLowerCase().equals("webcam")) {
								webcam = true;
							}
							if(cusElement.getElementsByTagName("b").item(0) != null)
							if (cusElement.getElementsByTagName("b").item(0).getTextContent().toLowerCase().equals("backlight")) {
								backlight = true;
							}
							if(cusElement.getElementsByTagName("f").item(0) != null)
							if (cusElement.getElementsByTagName("f").item(0).getTextContent().toLowerCase().equals("fingerprint")) {
								fingerprint = true;
							}
							if(cusElement.getElementsByTagName("t").item(0) != null)
							if (cusElement.getElementsByTagName("t").item(0).getTextContent().toLowerCase().equals("touchscreen")) {
								touchscreen = true;
							}
							
						}
					}
					oOrder.getDecorator().setApearence(webcam, backlight, fingerprint, touchscreen);
					orderList.add(oOrder);
				}
			}
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return orderList;
	}



	public ArrayList<Order> getOrderList() {
		return orderList;
	}



	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

}
