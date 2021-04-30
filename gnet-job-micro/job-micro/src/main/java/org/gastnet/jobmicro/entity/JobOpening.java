package org.gastnet.jobmicro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gastnet.jobmicro.enumeration.JobOpeningStatus;
import org.gastnet.jobmicro.enumeration.JobShiftType;
import org.gastnet.jobmicro.enumeration.JobTitle;
import org.gastnet.jobmicro.enumeration.WageType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @Column
    private BigDecimal wage;

    @Column
    @Enumerated(EnumType.STRING)
    private WageType wageType;

    @Column(columnDefinition = "text")
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date postedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date expiryDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private JobOpeningStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private JobShiftType jobShiftType;

    @Column(nullable = false, updatable = false)
    private Long businessId;

    @OneToMany(mappedBy = "jobOpening", fetch = FetchType.LAZY)
    private Set<JobApplication> jobApplications = new HashSet<>();

}
