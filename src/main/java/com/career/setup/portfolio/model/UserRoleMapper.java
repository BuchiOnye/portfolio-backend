package com.career.setup.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_role_mapper")
@Getter
@Setter
public class UserRoleMapper{

	@Id
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false)
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_fk", nullable = false)
	private AppUser user;


}
