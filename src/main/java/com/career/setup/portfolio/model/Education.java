package com.career.setup.portfolio.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String institution;
    private String degree;
    private Date dateAwarded;
    private Boolean inProgress;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
