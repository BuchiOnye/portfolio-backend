package com.career.setup.portfolio.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String surname;
    private String middleName;
    private Date dob;
    private String title;
    private String hobbies;
    private String picture;
    private String summary;
    private String country;
    private Boolean isOpenToNetwork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;

    @OneToOne
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "profile")
    private Set<Accomplishment> accomplishments;

    @OneToMany(mappedBy = "profile")
    private Set<Skill> skills;

    @OneToMany(mappedBy = "profile")
    private Set<Education> education;

    @OneToMany(mappedBy = "profile")
    private Set<Recommendation> recommendations;

}
