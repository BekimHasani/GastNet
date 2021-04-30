package org.gastnet.reviewmicro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpertiseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;

    @Column
    private String comment;

    @Column(nullable = false)
    private Long individualId;

    @Column(nullable = false)
    private Long businessId;
}
