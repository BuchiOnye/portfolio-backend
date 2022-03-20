package com.career.setup.portfolio.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String title;
    private String jobTitile;
    private String relationship;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
