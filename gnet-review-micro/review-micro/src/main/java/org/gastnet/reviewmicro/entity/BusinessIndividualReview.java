package org.gastnet.reviewmicro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessIndividualReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessIndividualReviewId;

    @Column(nullable = false)
    private Integer rating;

    @Column
    private String comment;

    @Column(nullable = false)
    private Long individualId;

    @Column(nullable = false)
    private Long businessId;
}
