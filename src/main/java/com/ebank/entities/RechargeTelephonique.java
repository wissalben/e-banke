package com.ebank.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Table(name="rechargeTelephonique")

public class RechargeTelephonique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rechargeTelephonique")
    private Long numeroRechargeTelephonique;
	
	@Column(name="montant")
    private BigDecimal montant;
	
	@Column(name="numeroTelephone")
    private String numeroTelephone;
	
	
	 
	@Column(name="dateRecharge")
	private Date dateRecharge;
	
	@ManyToOne
    @JoinColumn(name = "Compte")
    private Compte compte;
	
	@ManyToOne
    @JoinColumn(name = "Operateur")
    private Operateur operateur;
	
	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	

	public Date getDateRecharge() {
		return dateRecharge;
	}

	public void setDateRecharge(Date dateRecharge) {
		this.dateRecharge = dateRecharge;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getNumeroRechargeTelephonique() {
		return numeroRechargeTelephonique;
	}

	public void setNumeroRechargeTelephonique(Long numeroRechargeTelephonique) {
		this.numeroRechargeTelephonique = numeroRechargeTelephonique;
	}
	

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public RechargeTelephonique(BigDecimal montant, String numeroTelephone, Date dateRecharge,Compte compte,Operateur operateur) {
		super();
		this.compte=compte;
		this.montant = montant;
		this.numeroTelephone = numeroTelephone;
		this.dateRecharge = dateRecharge;
		this.operateur=operateur;
		
	}

	public RechargeTelephonique() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	







	

}
