package com.ebank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity

public class Contrat {
    @Id 
    @Column(name="numeroContrat")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroContrat;
    
    @Column(name="dateCreation")
    private Date dateCreation;

    @ManyToOne
	@JoinColumn(name="numeroClient")
private Client client;
    
    
    public Contrat() {
    }

    public Contrat(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(Long numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Contrat(Date dateCreation, Client client) {
		super();
		this.dateCreation = dateCreation;
		this.client = client;
	}
    
}
