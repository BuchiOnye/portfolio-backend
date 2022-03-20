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

@Entity
@Data
@Table
public class Accomplishment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Date date;
    private String link;
    private String awardedBy;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
