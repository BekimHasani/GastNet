package org.gastnet.clientmicro.enumeration;

public enum URL {
	
	USER("http://localhost:8082/api/user/users/"),
	ADMIN("http://localhost:8082/api/user/admin/"),

	BUSINESS_INDIVIDUAL_REVIEW("http://localhost:8082/api/review/business-individual-review/"),
	BUSINESS_REVIEW("http://localhost:8082/api/review/business-review/"),
	EXPERTISE_REVIEW("http://localhost:8082/api/review/expertise-review/"),
	INDIVIDUAL_REVIEW("http://localhost:8082/api/review/individual-review/"),
	SKILL_REVIEW("http://localhost:8082/api/review/skills-review/"),
	
	INDIVIDUAL("http://localhost:8082/api/individual/individuals/"),
	INDIVIDUAL_SKILL("http://localhost:8082/api/individual/individual-skills/"),
	EXPERIENCE("http://localhost:8082/api/individual/experiences/"),
	PROFESSIONAL_DATA("http://localhost:8082/api/individual/professional-data/"),
	SKILL("http://localhost:8082/api/individual/skills/"),
	
	BUSINESS("http://localhost:8082/api/business/businesses/"),
	BUSIENSS_EXPERTISE("http://localhost:8082/api/business/expertises/"),
	BUSINESS_IMAGE("http://localhost:8082/api/business/images/"),
	BUSINESS_CONTACT("http://localhost:8082/api/business/contacts/"),
	BUSINESS_LOCATION("http://localhost:8082/api/business/locations/"),
	
	JOB_ATTACHMENT("http://localhost:8082/api/job/attachments/"),
	JOB_APPLICATION("http://localhost:8082/api/job/application/"),
	JOB_OPENING("http://localhost:8082/api/job/openings/"),
	
	REGISTER("http://localhost:8082/register/"),
	LOGIN("http://localhost:8082/login"),
	LOGOUT("http://localhost:8082/logout");
	
	private String value;
	
	private URL(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
