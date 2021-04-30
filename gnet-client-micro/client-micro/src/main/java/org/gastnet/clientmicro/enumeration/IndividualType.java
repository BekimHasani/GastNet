package org.gastnet.clientmicro.enumeration;

public enum IndividualType {
	EMPLOYEE("Employee"),
	FIELD_SPECIALIST("Field Specialist"),
	FIELD_CRITIC("Field Critic");
	
	private String value;
	
	private IndividualType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
