package com.career.setup.portfolio.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRoleMapper> roleMappers = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<RolePrivilegeMapper> rolePrivilegeMapper;

}
