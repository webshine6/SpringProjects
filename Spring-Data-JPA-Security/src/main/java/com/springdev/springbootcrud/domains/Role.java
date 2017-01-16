package com.springdev.springbootcrud.domains;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ROLE")
public class Role {

	private Long roleid;
	
	@Column(name = "type", length = 10, unique = true, nullable = false)
	private String type;

	private Set<User> users = new HashSet<User>();

	@Id
	@GeneratedValue
	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@NotEmpty
	@ManyToMany(mappedBy = "roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
