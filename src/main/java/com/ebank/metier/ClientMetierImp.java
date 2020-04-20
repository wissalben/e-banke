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
import com.ebank.dao.OperateurRepository;
import com.ebank.dao.OperationRepository;
import com.ebank.dao.RechargeTelephoniqueRepository;
import com.ebank.entities.Agent;
import com.ebank.entities.Client;
import com.ebank.entities.Compte;
import com.ebank.entities.CompteCourant;
import com.ebank.entities.Operateur;
import com.ebank.entities.Operation;
import com.ebank.entities.RechargeTelephonique;
import com.ebank.entities.Retrait;
import com.ebank.entities.Versement;
import com.ebank.entities.Virement;

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
	
	@Autowired
	private OperateurRepository operateurRepository;
	
	public void verser(String codeCpte, BigDecimal montant) {
		Compte cp=consulterCompte(codeCpte);
		Versement v=new Versement(new Date(),montant,cp);
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
		
		
		cp.setSolde((cp.getSolde()).subtract(montant));
		compteRepository.save(cp);
		
		
	}
	public Compte consulterCompte(String pin) {
		Compte cp=compteRepository.findByPin(pin);
		if(cp==null) throw new RuntimeException("Compte Introuvable");
		
		return cp;
	}

	

	
	public void virement(String codeCpte, Long codeCpte2, BigDecimal montant) {
		
		
		
		Compte cp=consulterCompte(codeCpte);
		Compte cp2=consulterCompteDestinataire(codeCpte2);
		if((cp.getClient()).equals(cp2.getClient())) throw new RuntimeException("virement nom effectuer");
		Virement vi=new Virement(new Date(),montant,cp,codeCpte2);
	    BigDecimal facilitesCaisse=new BigDecimal(0);;
		if(cp instanceof CompteCourant) 
			facilitesCaisse=((CompteCourant) cp).getDecouvert();
			
		if((montant).compareTo((cp.getSolde()).add(facilitesCaisse))>0)
		{ throw new RuntimeException("Solde insuffisant");}
		
		else{cp.setSolde((cp.getSolde()).subtract(montant));}
		
		compteRepository.save(cp);
		
		cp2.setSolde((cp2.getSolde()).add(montant));
		compteRepository.save(cp2);
		
		
		operationRepository.save(vi);
		
		
		
	}
public Compte consulterCompteDestinataire(Long codeCpte) {
		 
		
		Compte cp=compteRepository.findById(codeCpte).orElse(null);
		if(cp==null) throw new RuntimeException("Compte Introuvable");
		
		return cp;
	}

public Operateur consulterOperateur(Long codeCpte) {
	 
	
	Operateur op=operateurRepository.findById(codeCpte).orElse(null);
	if(op==null) throw new RuntimeException("operateur Introuvable");
	
	return op;
}
	
	
	
	
	
	
	@Override
	public void rechargeTelephonique(String pin,Long codeOperateur, String numeroTelephone, BigDecimal montant) {
		
		Compte cp=consulterCompte(pin);
		Operateur op=consulterOperateur(codeOperateur);
		RechargeTelephonique re=new RechargeTelephonique(montant,numeroTelephone,new Date(),cp,op);
	    BigDecimal facilitesCaisse=new BigDecimal(0);;
		if(cp instanceof CompteCourant) 
			facilitesCaisse=((CompteCourant) cp).getDecouvert();
			
		if((montant).compareTo((cp.getSolde()).add(facilitesCaisse))>0)
		{ throw new RuntimeException("Solde insuffisant");}
		
		else{cp.setSolde((cp.getSolde()).subtract(montant));}
		
		compteRepository.save(cp);
		operateurRepository.save(op);
		
		
		
		rechargeTelephoniqueRepository.save(re);
		
		
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

