package com.springdev.springbootcrud.domains;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userid;
	
	@NotEmpty @Size(min = 5, max = 10)
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotEmpty
	@Column(nullable = false)
	private String password;
	
	@NotEmpty
	@Email
	@Column(nullable = false)
	private String email;
	
	
	private Set<Role> roles = new HashSet<Role>();


	public User() {
	
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue
	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@ManyToMany(fetch = FetchType.LAZY) 
	@JoinTable(name = "USER_ROLE", 
			   joinColumns = { @JoinColumn(name = "userid") },
			   inverseJoinColumns = { @JoinColumn(name="roleid")} )
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ","
				+ "   username=" + username + ","
				    + " roles=" + roles + "]";
	}

}
