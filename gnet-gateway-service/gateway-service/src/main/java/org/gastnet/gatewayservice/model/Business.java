package org.gastnet.gatewayservice.model;

import java.util.HashSet;
import java.util.Set;

import org.gastnet.gatewayservice.enumeration.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

	private String name;

	private String businessNumber;

	private String description;

	private Category category;

	private Set<Contact> contacts = new HashSet<>();

	private Set<Location> locations = new HashSet<>();

}
