package org.gastnet.usermicro.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.gastnet.usermicro.command.CreateUserForIndividualCommand;
import org.gastnet.usermicro.command.FinishIndividualUserCreationCommand;
import org.gastnet.usermicro.enumeration.Role;
import org.gastnet.usermicro.enumeration.UserState;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Aggregate
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@AggregateIdentifier
	private Long userId;
	
	@Column(nullable = false , unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date creationDate;
	
	@Column(nullable = false)
	private boolean status;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	private UserState userState;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<Report> reports = new HashSet<>();
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private Boolean googleUser;
	
}
	
