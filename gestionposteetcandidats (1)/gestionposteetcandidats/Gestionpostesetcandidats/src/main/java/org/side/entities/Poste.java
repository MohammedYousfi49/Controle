package org.side.entities;

import java.time.LocalDate;
//import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="postes")
public class Poste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Titre",nullable = false)
	private String titre;
	@Column(name="Description")
    private String description;
	@Column(name="Date-Fin-Candidature")
	 private LocalDate dateFinCandidature;


   public Poste() {

   }



	public Poste(String titre, String description, LocalDate dateFinCandidature) {
	super();
	this.titre = titre;
	this.description = description;
	this.dateFinCandidature = dateFinCandidature;
}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDate getDateFinCandidature() {
		return dateFinCandidature;
	}



	public void setDateFinCandidature(LocalDate dateFinCandidature) {
		this.dateFinCandidature = dateFinCandidature;
	}












}
