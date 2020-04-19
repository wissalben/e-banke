package com.ebank.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeOperation", discriminatorType = DiscriminatorType.STRING, length = 10)
@Table(name=" operation ")
public abstract class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numeroOperation")
    private Long numeroOperation;
	
	@Column(name="dateOperation")
    private Date dateOperation;
	

	@Column(name="montant")
    private BigDecimal montant;
	
    @ManyToOne
    @JoinColumn(name = "Compte")
    private Compte compte;

    public Operation() {
    }

    public Operation(Date dateOperation, BigDecimal montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }

    public Long getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(Long numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
