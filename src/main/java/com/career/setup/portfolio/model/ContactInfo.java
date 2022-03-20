package com.career.setup.portfolio.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class ContactInfo {
    @Id
    private Long id;
    private String email;
    private String phoneNumber;
    private String associatedLink;

}
