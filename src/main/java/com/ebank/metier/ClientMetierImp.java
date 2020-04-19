package com.ebank.metier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebank.dao.ClientRepository;
import com.ebank.dao.CompteRepository;
import com.ebank.dao.OperationRepository;
import com.ebank.dao.RechargeTelephoniqueRepository;
import com.ebank.entities.Agent;
import com.ebank.entities.Client;
import com.ebank.entities.Compte;
import com.ebank.entities.CompteCourant;
import com.ebank.entities.Operation;
import com.ebank.entities.RechargeTelephonique;
import com.ebank.entities.Retrait;
import com.ebank.entities.Versement;

@Service
@Transactional
public class ClientMetierImp implements ClientMetier {
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private RechargeTelephoniqueRepository rechargeTelephoniqueRepository;
	
	
	public void verser(String codeCpte, BigDecimal montant) {
		Compte cp=consulterCompte(codeCpte);
		Versement v=new Versement(new Date(),montant,cp);
		operationRepository.save(v);
		cp.setSolde((cp.getSolde()).add(montant));
		compteRepository.save(cp);
		
	}
	
	@Override
	public void retirer(String codeCpte, BigDecimal montant) {
		Compte cp=consulterCompte(codeCpte);
		Retrait r=new Retrait(new Date(),montant,cp);
		BigDecimal facilitesCaisse=new BigDecimal(0);;
		if(cp instanceof CompteCourant) 
			facilitesCaisse=((CompteCourant) cp).getDecouvert();
			
		if(((cp.getSolde()).add(facilitesCaisse)).compareTo(montant)< 0)
			 throw new RuntimeException("Solde insuffisant");
		
		operationRepository.save(r);
		cp.setSolde((cp.getSolde()).subtract(montant));
		compteRepository.save(cp);
		
		
	}
	public Compte consulterCompte(String pin) {
		Compte cp=compteRepository.findByPin(pin);
		if(cp==null) throw new RuntimeException("Compte Introuvable");
		
		return cp;
	}

	

	
	public void virement(String codeCpte, String codeCpte2, BigDecimal montant) {
		if(codeCpte.equals(codeCpte2))
			throw new RuntimeException("impossible de virer sur le meme compte !");
		
		
		retirer(codeCpte,montant);
		verser(codeCpte2,montant);
		
	}

	
	
	
	
	
	
	@Override
	public void rechargeTelephonique(String codeCompte,String codeOperateur, String numeroTelephone, BigDecimal montant) {
		retirer(codeCompte,montant);
		verser(codeOperateur,montant);
		
	}
	@Override
	public Agent consulterAgent(Long numeroClient) {
		Optional<Client> cl=clientRepository.findById(numeroClient);
		Agent ag= new Agent();
		if(!ag.equals(cl.get().getAgent())) throw new RuntimeException("Agent introuvable");
		return ag;
	

		
	}

	@Override
	public Page<Operation> listOperation_Virement_(String codeCpte, Integer page, Integer size) {
		
		return operationRepository.listOperation(codeCpte,PageRequest.of(page, size) );
	}

	@Override
	public Page<RechargeTelephonique> listOperation_Recharge_(String codeCpte, Integer page, Integer size) {
		
		return rechargeTelephoniqueRepository.listRecharge(codeCpte, PageRequest.of(page, size));
	}

	@Override
	public Client consulterClient(String nomUtilisateur, String motDePasse) {
		Client cl=clientRepository.findByNomUtilisateur(nomUtilisateur);
		if(!motDePasse.equals(cl.getMotDePasse())) throw new RuntimeException("Client introuvable");
		return cl;
	}

   
	
	

}

