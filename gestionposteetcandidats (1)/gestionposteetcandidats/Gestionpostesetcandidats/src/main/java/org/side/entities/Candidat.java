package org.side.entities;

import jakarta.persistence.*;


@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Email")
    private String email;
    @Lob
    private byte[] cv;

    public Candidat() {

    }


    public Candidat(Long id, String nom, String email, byte[] cv) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.cv = cv;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}