package org.side.entities;

import java.time.LocalDate;



public class PosteDto {
	private String titre;
    private String description;
    private LocalDate dateFinCandidature;
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
