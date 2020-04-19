package com.ebank.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeCompte", discriminatorType = DiscriminatorType.STRING, length = 10)
@Table(name=" compte ")
public abstract class Compte implements Serializable{
    @Id 
    @Column(name="codeCompte")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeCompte;
    
    @Column(name="dateCreation")
    private Date dateCreation;
    
    @Column(name="Solde")
    private BigDecimal solde;
    
    @Column(name="actif")
    private boolean actif;
    
    @Column(name="pin")
    private String pin;
    
    @ManyToOne
    @JoinColumn(name = "Client")
    private Client client;
    
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;
    
    @OneToMany(mappedBy = "compte")
    private Collection<RechargeTelephonique> recharges;
    


    public Compte() {
    }

    public Compte(Date dateCreation, BigDecimal solde, boolean actif, Client client) {
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.actif = actif;
        this.client = client;
        Random random = new Random();
        this.pin = String.format("%04d", random.nextInt(10000));
    }

    public Long getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte(Long codeCompte) {
        this.codeCompte = codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

	

	public Collection<RechargeTelephonique> getRecharges() {
		return recharges;
	}

	public void setRecharges(Collection<RechargeTelephonique> recharges) {
		this.recharges = recharges;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
    
}
