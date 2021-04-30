package org.gastnet.clientmicro.enumeration;

public enum Category {
	FASTFOOD("Fastfood"),
	RESTAURANT("Restaurant"),
	HOTEL("Hotel");
	
	private String value;
	
	private Category(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
