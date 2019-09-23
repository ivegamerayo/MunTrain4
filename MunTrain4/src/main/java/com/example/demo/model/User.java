package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;


	@Column (name = "email")
	private String email;


	@Column (name = "login")
	private String login;

	@Column (name = "password")
	private String password;

	public User() {
	}
	
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public User(String email, String login, String password) {
		super();
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public User(Long id, String email, String login, String password) {
		super();
		this.id = id;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}