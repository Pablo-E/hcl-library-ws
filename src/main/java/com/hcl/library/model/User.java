package com.hcl.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id_user")
	private int idUser;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "gender")
	private char gender;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private int mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private Address address;

	@Column(name = "status")
	private int status;

	@Column(name = "role")
	private String role;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Loan> loans = new ArrayList<>();

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", lastname=" + lastname + ", gender=" + gender
				+ ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", status=" + status + ", role="
				+ role + "]";
	}
	
}









