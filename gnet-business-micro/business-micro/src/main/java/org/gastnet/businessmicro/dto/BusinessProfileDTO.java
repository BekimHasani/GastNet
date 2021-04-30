package org.gastnet.businessmicro.dto;

import java.util.Collections;
import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.BusinessExpertise;
import org.gastnet.businessmicro.entity.Contact;
import org.gastnet.businessmicro.entity.Location;

import lombok.Data;

@Data
public class BusinessProfileDTO {
	
	private Business business;
	private Set<Location> locations;
	private Set<Contact> contacts;
	private Set<BusinessExpertise> expertises;

	private BusinessProfileDTO(Builder builder) {
		this.business = builder.business;
		this.locations = builder.locations;
		this.contacts = builder.contacts;
		this.expertises = builder.expertises;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Business business;
		private Set<Location> locations = Collections.emptySet();
		private Set<Contact> contacts = Collections.emptySet();
		private Set<BusinessExpertise> expertises = Collections.emptySet();;

		private Builder() {
		}

		public Builder business(Business business) {
			this.business = business;
			return this;
		}

		public Builder locations(Set<Location> locations) {
			this.locations = locations;
			return this;
		}

		public Builder contacts(Set<Contact> contacts) {
			this.contacts = contacts;
			return this;
		}
		
		public Builder expertises(Set<BusinessExpertise> expertises) {
			this.expertises = expertises;
			return this;
		}

		public BusinessProfileDTO build() {
			return new BusinessProfileDTO(this);
		}
	}
	
	
}
