package org.gastnet.individualmicro.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.IndividualSkill;
import org.gastnet.individualmicro.entity.ProfessionalData;
import org.gastnet.individualmicro.enumeration.IndividualType;

public class IndividualUser {
	
	public static class Builder {
		
		private Long individualId;
		private String name;
		private String lastName;
		private Date birthDate;
		private char gender;
		private String city;
		private String state;
		private String phoneNumber;
		private String imageUrl;
		private IndividualType individualType;
		private Long userId;
		private Set<Experience> experiences = new HashSet<>();
		private Set<IndividualSkill> individualSkills = new HashSet<>();
		private Set<ProfessionalData> professionalData = new HashSet<>();

		public IndividualModel build() {
			IndividualModel individual = new IndividualModel();
			individual.setIndividualId(individualId);
			individual.setName(name);
			individual.setLastName(lastName);
			individual.setBirthDate(birthDate);
			individual.setGender(gender);
			individual.setCity(city);
			individual.setState(state);
			individual.setPhoneNumber(phoneNumber);
			individual.setImageUrl(imageUrl);
			individual.setIndividualType(individualType);
			individual.setUserId(userId);
			individual.setExperiences(experiences);
			individual.setIndividualSkills(individualSkills);
			individual.setProfessionalData(professionalData);
			return individual;
		}

		public Builder individualId(Long individualId) {
			this.individualId = individualId;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder birthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder gender(char gender) {
			this.gender = gender;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder state(String state) {
			this.state = state;
			return this;
		}

		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder imageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}

		public Builder individualType(IndividualType individualType) {
			this.individualType = individualType;
			return this;
		}

		public Builder userId(Long userId) {
			this.userId = userId;
			return this;
		}

		public Builder experiences(Set<Experience> experiences) {
			this.experiences = experiences;
			return this;
		}

		public Builder individualSkills(Set<IndividualSkill> individualSkills) {
			this.individualSkills = individualSkills;
			return this;
		}

		public Builder professionalData(Set<ProfessionalData> professionalData) {
			this.professionalData = professionalData;
			return this;
		}
	}

	private IndividualUser() {
	}
	
}
