package com.ebank.metier;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import com.ebank.entities.Agent;
import com.ebank.entities.Client;
import com.ebank.entities.Compte;
import com.ebank.entities.Operation;
import com.ebank.entities.RechargeTelephonique;

public interface ClientMetier {
	 public Compte consulterCompte(String pin);
	 public Agent consulterAgent(Long numeroClient);
	 public void virement (String codeCpte1,String codecpte2,BigDecimal montant);
	 public Page<Operation> listOperation_Virement_(String codeCpte,Integer page,Integer size);
	 public Client consulterClient(String nomUtilisateur,String motDePasse);
	 void retirer(String codeCpte, BigDecimal montant);
	 void rechargeTelephonique(String codeCompte, String codeOperateur, String numeroTelephone, BigDecimal montant);
	 public Page<RechargeTelephonique> listOperation_Recharge_(String codeCpte,Integer page,Integer size);
}
