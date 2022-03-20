package com.career.setup.portfolio.model;

import com.career.setup.portfolio.model.enums.HardSkill;
import com.career.setup.portfolio.model.enums.SoftSkill;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private HardSkill hardSkill;

    @Enumerated(EnumType.STRING)
    private SoftSkill softSkill;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
