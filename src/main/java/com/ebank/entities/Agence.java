package com.ebank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Date;

@Entity
public class Agence {
    @Id @GeneratedValue
    private Long numeroAgence;
    private String nomAgence;
    private String adresse;
    private String email;
    private String fixe;
    private String tele;
    private String description;
    @OneToMany(mappedBy = "agence")
    private Collection<Agent> agents;
    private Date dateCreation;
    private String autorisation;

    public Agence() {
    }

    public Agence(String nomAgence, String adresse, String email, String fixe, String tele, String description, Date dateCreation, String autorisation) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.email = email;
        this.fixe = fixe;
        this.tele = tele;
        this.description = description;
        this.dateCreation = dateCreation;
        this.autorisation = autorisation;
    }

    public Long getNumeroAgence() {
        return numeroAgence;
    }

    public void setNumeroAgence(Long numeroAgence) {
        this.numeroAgence = numeroAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Collection<Agent> agents) {
        this.agents = agents;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(String autorisation) {
        this.autorisation = autorisation;
    }
}
