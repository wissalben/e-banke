package com.ebank.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@Entity
public class Agent {
    @Id @GeneratedValue
    private Long numeroAgent;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String fonction;
    private String statusSocial;
    private String CNI;
    private Date dateEmbauche;
    private double salaire;
    private String description;
    private String nomUtilisateur;
    private String motDePasse;
    private  String email;
    private String telephone;
    private String fix;
    private String faxe;
    @ManyToOne
    @JoinColumn(name = "Agence")
    private Agence agence;
    @OneToMany(mappedBy = "agent")
    private Collection<Client> clients;

   

    public Agent(String nom, String prenom, Date dateNaissance, String adresse, String fonction, String statusSocial,
			String cNI, Date dateEmbauche, double salaire, String description, String nomUtilisateur, String motDePasse,
			String email, String telephone, String fix, String faxe, Agence agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.fonction = fonction;
		this.statusSocial = statusSocial;
		CNI = cNI;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
		this.description = description;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.email = email;
		this.telephone = telephone;
		this.fix = fix;
		this.faxe = faxe;
		this.agence = agence;
	
	}
    

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}


	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getFix() {
		return fix;
	}


	public void setFix(String fix) {
		this.fix = fix;
	}


	public String getFaxe() {
		return faxe;
	}


	public void setFaxe(String faxe) {
		this.faxe = faxe;
	}


	public Long getNumeroAgent() {
        return numeroAgent;
    }

    public void setNumeroAgent(Long numeroAgent) {
        this.numeroAgent = numeroAgent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getStatusSocial() {
        return statusSocial;
    }

    public void setStatusSocial(String statusSocial) {
        this.statusSocial = statusSocial;
    }

    public String getCNI() {
        return CNI;
    }

    public void setCNI(String CNI) {
        this.CNI = CNI;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
