package com.ebank.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@Table(name=" client ")

public class Client {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numeroClient")
    private Long numeroClient;
	
	@Column(name="nom")
    private String nom;
	
	@Column(name="prenom")
    private String prenom;
    
	@Column(name="dateNaissance")
    private Date dateNaissance;
    
    @Column(name="adresse")
    private String adresse;
    
    @Column(name="fonction")
    private String fonction;
    
    @Column(name="statutSocial")
    private String statusSocial;
    
    @Column(name="CNI")
    private String CNI;

	@Column(name="nomUtilisateur")
    private String nomUtilisateur;
	
	@Column(name="motDePasse")
    private String motDePasse;
	
    @ManyToOne
    @JoinColumn(name = "agent")
    private Agent agent;
    
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;
    
    @Column(name="active")
    private boolean active;
    
   
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NumeroContrat", referencedColumnName = "numeroContrat")
    private Contrat contrat;
   

    public Client(String nom, String prenom, Date dateNaissance, String adresse,String motDePasse, String fonction, String statusSocial, String CNI, Agent agent, boolean active, Contrat contrat) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.fonction = fonction;
        this.statusSocial = statusSocial;
        this.CNI = CNI;
        this.agent = agent;
        this.active = active;
        this.contrat = contrat;
        this.motDePasse=motDePasse;
        Random rand = new Random();
        if(nom != null && prenom != null) nomUtilisateur = nom + "." + prenom + rand.nextInt(1000);
    }

    public Long getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(Long numeroClient) {
        this.numeroClient = numeroClient;
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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
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

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
