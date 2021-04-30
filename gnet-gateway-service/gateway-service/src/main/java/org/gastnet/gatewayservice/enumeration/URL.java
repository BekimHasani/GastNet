package org.gastnet.gatewayservice.enumeration;

public enum URL {
	INDIVIDUAL("http://individual-micro/individuals/"),
	USER("http://user-micro/users/"),
	BUSINESS("http://business-micro/businesses/");

	private String value;
	
	private URL(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
