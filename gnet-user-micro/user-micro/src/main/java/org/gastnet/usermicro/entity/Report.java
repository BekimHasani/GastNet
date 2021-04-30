package org.gastnet.usermicro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.gastnet.usermicro.enumeration.ReportStatus;
import org.gastnet.usermicro.enumeration.ReportType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private Long objectId;
	
	@Column(nullable = false,length = 40)
	private String objectType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false , length = 30)
	private ReportType reportType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false , length = 30)
	private ReportStatus reportStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
