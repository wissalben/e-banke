package com.ebank.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Table(name="operateur")

public class Operateur {
	@Id
	@Column(name="codeOperateur")
	private String code0perateur;
	@Column(name="nomOperateur")
	private String nomOperateur;
	
	
	@Column(name="licence")
	private String license;
	
	public Operateur(String code0perateur, String nomOperateur, String license) {
		super();
		this.code0perateur = code0perateur;
		this.nomOperateur = nomOperateur;
		this.license = license;
	}

	public Operateur() {
		super();
		
	}
	
	

}
