package com.ebank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "CC")

public class CompteCourant extends Compte {

    private BigDecimal decouvert;

    public CompteCourant() {
        super();
    }

    public CompteCourant(Date dateCreation, BigDecimal solde, boolean actif, Client client, BigDecimal i) {
        super(dateCreation, solde, actif, client);
        this.decouvert = i;
    }

    public BigDecimal getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(BigDecimal decouvert) {
        this.decouvert = decouvert;
    }
}
