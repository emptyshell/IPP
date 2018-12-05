package customization;

public class Color implements ProductColor {
	private String pType = "";
	private String pColor;
	private boolean[][] colorArray = new boolean[][] {
					//[0]silver [1]black [2]white [3]blue
		/*0 netbook */{false, true, true, false},
		/*1 notebook */{true, true, false, true},
		/*2 gamebook */{true, true, true, true},
		/*3 ultrabook*/{true, true, false, false}
		};
	public Color () {
		this.pColor = "";
	}
		
	@Override
	public String setColor(String color) {
		if (this.getIndexByPType(pType)>=0) 
		switch (color.toLowerCase()) {
		case "silver":
			if (colorArray[this.getIndexByPType(pType)][0])
				return "silver";
		case "black":
			if (colorArray[this.getIndexByPType(pType)][1])
				return "black";
		case "white":
		if (colorArray[this.getIndexByPType(pType)][2])
			return "white";
		case "blue":
			if (colorArray[this.getIndexByPType(pType)][3])
				return "blue";
		default:
			return "color isn't available";
		}
		else
			return "dont have any colort for this type "+pType;
	}
	public boolean[][] getColorArray() {
		return colorArray;
	}
	
	public boolean[] getColorArray(int row) {
		return colorArray[row];
	}
	
	public boolean getColorArray(int row,int column) {
		return colorArray[row][column];
	}
	
	public void setColorArray(boolean[][] colorArray) {
		this.colorArray = colorArray;
	}
	
	public void setPType(String pType) {
		//System.out.println(pType);
		this.pType = pType;
	}
	
	public String getPType() {
		return this.pType;
	}
	
	public int getIndexByPType(String pType) {
		if(pType.contains("basic")) {
			pType = pType.replace("basic", "");
		}
		else if (pType.contains("advanced")){
			pType = pType.replace("advanced", "");
		}
		switch (pType.toLowerCase()) {
		case "netbook":
			return 0;
		case "notebook":
			return 1;
		case "gamebook":
			return 2;
		case "ultrabook":
			return 3;
		default:
			return -1;
		}
	}
	public String getpColor() {
		return pColor;
	}
	public void setpColor(String pColor) {
		this.pColor = pColor;
	}
	
	public Color (String color,String productType) {
		this.setPType(productType);
		this.setColor(color);
	}
	
	public String getColorByColumn(int column) {
		switch (column) {
		case 0:
			return "silver";
		case 1:
			return "black";
		case 2:
			return "white";
		case 3:
			return "blue";
		}
	return "";
	}
}
