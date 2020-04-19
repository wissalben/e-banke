package com.ebank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "CE")
public class CompteEpargne extends Compte {

    private BigDecimal taux;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(Date dateCreation, BigDecimal solde, boolean actif, Client client, BigDecimal taux) {
        super(dateCreation, solde, actif, client);
        this.taux = taux;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }
}
