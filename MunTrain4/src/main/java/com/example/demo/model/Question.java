package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table (name = "question")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;

	@Lob
	@Column(name = "description")
	private String description;
	
	
	/*
	 * @ManyToOne (fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn (name = "id_examtemplate") private Examtemplate examtemplate;
	 */
	
	@ManyToOne
	@JoinColumn(name="id_examtemplate", insertable=false, updatable=false)
	private Examtemplate examtemplate;

	@OneToMany (mappedBy = "question") 
	private List<Response> response = new ArrayList<Response>();
	
	
	public Question() {
	}

	public Question(String description) {
		super();
		this.description = description;
	}

	public Question(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Question(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public Question(Long id, String description, Examtemplate examtemplate, List<Response> response) {
		super();
		this.id = id;
		this.description = description;
		this.examtemplate = examtemplate;
		this.response = response;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	  public Examtemplate getExamtemplate() { 
		  return examtemplate; 
	  }
	  
	public void setExamtemplate(Examtemplate examtemplate) { 
		this.examtemplate = examtemplate; 
	}
	
	
	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}

}
