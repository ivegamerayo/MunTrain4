package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the examtemplate database table.
 * 
 */
@Entity
@Table (name = "examtemplate")
@NamedQuery(name="Examtemplate.findAll", query="SELECT e FROM Examtemplate e")
public class Examtemplate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="descriptionET")
	private String descriptionET;


	@Column(name="publisher")
	private boolean publisher;
	
	/*
	 * @Column(name="dificulty") private int dificulty;
	 */
	
	
	 @OneToMany (fetch = FetchType.EAGER) 
	 @JoinColumn (name ="id_examtemplate") 
	 private List<Question> question = new ArrayList<Question>();
	
	
	/*
	 * @OneToMany (mappedBy = "examtemplate") private List<Question> question = new
	 * ArrayList<Question>();
	 */
	 
	 
	
	public Examtemplate() {
	}
	
	public Examtemplate(String descriptionET, boolean publisher, List<Question> question) {
		super();
		this.descriptionET = descriptionET;
		this.publisher = publisher;
		this.question = question;
	}

	public Examtemplate(String descriptionET) {
		super();
		this.descriptionET = descriptionET;
	}

	
	public Examtemplate(String descriptionET, boolean publisher) {
		super();
		this.descriptionET = descriptionET;
		this.publisher = publisher;
	}

	public Examtemplate(Long id, String descriptionET, boolean publisher, List<Question> question) {
		super();
		this.id = id;
		this.descriptionET = descriptionET;
		this.publisher = publisher;
		this.question = question;
	}
	
	


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptionET() {
		return this.descriptionET;
	}

	public void setDescriptionET(String descriptionET) {
		this.descriptionET = descriptionET;
	}

	public boolean getPublisher() {
		return this.publisher;
	}

	public void setPublisher(boolean publisher) {
		this.publisher = publisher;
	}
	
	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return descriptionET;
	}

}