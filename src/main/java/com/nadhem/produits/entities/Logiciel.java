package com.nadhem.produits.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Logiciel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLogiciel;
	private String nomLogiciel;
	private Double prixLogiciel;
	private Date dateCreation;
	
	@ManyToOne
	private Developer developer;

	


	public Logiciel() {
		super();
	}

	public Logiciel(String nomLogiciel, Double prixLogiciel, Date dateCreation) {
		super();
		this.nomLogiciel = nomLogiciel;
		this.prixLogiciel = prixLogiciel;
		this.dateCreation = dateCreation;
	}



	public Long getIdLogiciel() {
		return idLogiciel;
	}

	public void setIdLogiciel(Long idLogiciel) {
		this.idLogiciel = idLogiciel;
	}

	public String getNomLogiciel() {
		return nomLogiciel;
	}

	public void setNomLogiciel(String nomLogiciel) {
		this.nomLogiciel = nomLogiciel;
	}

	public Double getPrixLogiciel() {
		return prixLogiciel;
	}

	public void setPrixLogiciel(Double prixLogiciel) {
		this.prixLogiciel = prixLogiciel;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "Logiciel [idLogiciel=" + idLogiciel + ", nomLogiciel=" + nomLogiciel + ", prixLogiciel=" + prixLogiciel
				+ ", dateCreation=" + dateCreation + "]";
	}
}
