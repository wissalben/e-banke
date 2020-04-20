package com.ebank.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Table(name="operateur")

public class Operateur {
	@Id
	@Column(name="codeOperateur")@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code0perateur;
	@Column(name="nomOperateur")
	private String nomOperateur;
	
	 @OneToMany(mappedBy = "operateur")
	    private Collection<RechargeTelephonique> recharges;
	 
	@Column(name="licence")
	private String license;
	
	public Operateur( String nomOperateur, String license) {
		super();
		
		this.nomOperateur = nomOperateur;
		this.license = license;
	}

	public Operateur() {
		super();
		
	}

	public Long getCode0perateur() {
		return code0perateur;
	}

	public void setCode0perateur(Long code0perateur) {
		this.code0perateur = code0perateur;
	}

	public String getNomOperateur() {
		return nomOperateur;
	}

	public void setNomOperateur(String nomOperateur) {
		this.nomOperateur = nomOperateur;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Collection<RechargeTelephonique> getRecharges() {
		return recharges;
	}

	public void setRecharges(Collection<RechargeTelephonique> recharges) {
		this.recharges = recharges;
	}
	
	

}
