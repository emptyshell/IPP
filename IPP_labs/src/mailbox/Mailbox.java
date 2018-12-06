package mailbox;

import java.io.File;

public class Mailbox {
	private String mailboxAddress = "/home/valentin/eclipse-workspace/lab1a_ipp/src/mailbox/mailbox.xml";
	private File xmlList = new File(mailboxAddress);
	

	public File getXmlList() {
		return xmlList;
	}

	public void setXmlList(String directory) {
		this.xmlList = new File(directory);
	}
}
