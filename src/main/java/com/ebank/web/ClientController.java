package com.ebank.web;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.ebank.entities.Agent;
import com.ebank.entities.Client;
import com.ebank.entities.Compte;
import com.ebank.entities.Operation;
import com.ebank.entities.RechargeTelephonique;
import com.ebank.metier.ClientMetier;

@Controller
public class ClientController {
	
	@Autowired
private ClientMetier clientMetier;
	

	@RequestMapping(value ="/espaceClient")
	public String index() {
		return "espaceClient";
	}
	
	@RequestMapping(value ="/virement")
	public String operation(Model model,String pin) {
		model.addAttribute("pin", pin);
		return "virement";
	}
	
	@RequestMapping(value ="/rechargeTelephonique")
	public String recharge(Model model,String pin) {
		model.addAttribute("pin", pin);
		return "RechargeTelephonique";
	}
	
	@RequestMapping(value ="/ConsulterClient")
	public String consulterCon(Model model,String nomUtilisateur,String motDePasse) {
		model.addAttribute("nomUtilisateur",nomUtilisateur);
		model.addAttribute("motDePasse",motDePasse);
		
		try{
	   Client cl=clientMetier.consulterClient(nomUtilisateur, motDePasse);
		
	    model.addAttribute("client",cl);
	   
		
		}
		catch(Exception e) {
			model.addAttribute("exception", e);
		}
		return "espaceClient";
	}
	
	@RequestMapping(value ="/consulterCompte")
	public String consulter(Model model,String pin,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="4")int size) {
		
		try{
	    Compte cp=clientMetier.consulterCompte(pin);
	    model.addAttribute("pin",pin);
	    model.addAttribute("compte",cp);
		Page<Operation> pageVirements=clientMetier.listOperation_Virement_(pin, page, size);
	    model.addAttribute("listVirements",pageVirements.getContent());
		int[] pagesV=new int[pageVirements.getTotalPages()];
		model.addAttribute("pagesV", pagesV);
		
		Page<RechargeTelephonique> pageRecharges=clientMetier.listOperation_Recharge_(pin, page, size);
	    model.addAttribute("listRecharges",pageRecharges.getContent());
		int[] pagesR=new int[pageRecharges.getTotalPages()];
		model.addAttribute("pagesR", pagesR);
		

	
		
		}
		catch(Exception e) {
			model.addAttribute("exception", e);
		}
		return "consulterCompte";
		
	}
	
	
	
	
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperation(Model model,String pin,BigDecimal montant,Long codeCompte2) {
		try{
			
		  
			  clientMetier.virement(pin, codeCompte2, montant);
		
		}
		catch(Exception e) {
			model.addAttribute("error",e);
		}
		return "redirect:/consulterCompte?pin="+pin;
	}
	
	@RequestMapping(value="/saveRecharge",method=RequestMethod.POST)
	public String saveRecharge(Model model,String pin,BigDecimal montant,String numeroTelephone,String typeRecharge) {
		try {
			if(typeRecharge.equals("inwi")) {
				 clientMetier.rechargeTelephonique(pin,(long)1,numeroTelephone,montant);
			}
			if(typeRecharge.equals("orange")) {
				 clientMetier.rechargeTelephonique(pin,(long)2,numeroTelephone,montant);
		                                      }
		  
		  if(typeRecharge.equals("marocTelecome")) {
			  clientMetier.rechargeTelephonique(pin,(long)3,numeroTelephone,montant);
		}
		
			
		
		}
		catch(Exception e) {
			model.addAttribute("error",e);
		}
		return "redirect:/consulterCompte?pin="+pin;
	}
}

