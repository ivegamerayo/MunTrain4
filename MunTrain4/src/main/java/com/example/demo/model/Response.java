package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the response database table.
 * 
 */
@Entity
@Table(name="response")
@NamedQuery(name="Response.findAll", query="SELECT r FROM Response r")
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;

	@Column(name="descriptionR")
	private String descriptionR;

	@Lob
	@Column(name="image")
	private String image;

	/*
	 * @Column(name="OrderR") private int orderR;
	 */

	@Column(name="value")
	private boolean value;
	
	

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "id_question")
	private Question question;

	public Response() {
	}
	
	public Response(String descriptionR, boolean value) {
		super();
		this.descriptionR = descriptionR;
		this.value = value;
	}

	public Response(String descriptionR, String image, boolean value) {
		super();
		this.descriptionR = descriptionR;
		this.image = image;
		this.value = value;
	}

	public Response(Long id) {
		super();
		this.id = id;
	}

	public Response(Long id, String descriptionR, String image, boolean value, Question question) {
		super();
		this.id = id;
		this.descriptionR = descriptionR;
		this.image = image;
		this.value = value;
		this.question = question;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptionR() {
		return this.descriptionR;
	}

	public void setDescriptionR(String descriptionR) {
		this.descriptionR = descriptionR;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/*
	 * public int getOrderR() { return this.orderR; }
	 * 
	 * public void setOrderR(int orderR) { this.orderR = orderR; }
	 */

	public boolean getValue() {
		return this.value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return id + descriptionR + value;
	}
}