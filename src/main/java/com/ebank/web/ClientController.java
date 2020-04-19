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
	
	@RequestMapping(value ="/consulterConseiller")
	public String consulterCon(Model model,Long numeroClient) {
		
		try{
	    Agent ag=clientMetier.consulterAgent(numeroClient);
		
	    model.addAttribute("agent",ag);
	   
		
		}
		catch(Exception e) {
			model.addAttribute("exception", e);
		}
		return "consulterConseiller";
	}
	
	@RequestMapping(value ="/consulterCompte")
	public String consulter(Model model,String pin,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="4")int size) {
		model.addAttribute("pin",pin);
		try{
	    Compte cp=clientMetier.consulterCompte(pin);
	    
		Page<Operation> pageVirements=clientMetier.listOperation_Virement_(pin, page, size);
	    model.addAttribute("listVirements",pageVirements.getContent());
		int[] pagesV=new int[pageVirements.getTotalPages()];
		model.addAttribute("pagesV", pagesV);
		
		Page<RechargeTelephonique> pageRecharges=clientMetier.listOperation_Recharge_(pin, page, size);
	    model.addAttribute("listRecahrages",pageRecharges.getContent());
		int[] pagesR=new int[pageRecharges.getTotalPages()];
		model.addAttribute("pagesR", pagesR);
		
	    model.addAttribute("compte",cp);
	
		
		}
		catch(Exception e) {
			model.addAttribute("exception", e);
		}
		return "consulterCompte";
		
	}
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,String pin,BigDecimal montant,String codeCompte2) {
		try{
			
		  if(typeOperation.equals("VIREMENT")) {
			  clientMetier.virement(pin, codeCompte2, montant);
		}
		}
		catch(Exception e) {
			model.addAttribute("error",e);
		}
		return "redirect:/consulterCompte?codeCompte="+pin;
	}
	
	@RequestMapping(value="/saveRecharge",method=RequestMethod.POST)
	public String saveRecharge(Model model,String typeRecharge,String pin,BigDecimal montant) {
		try{
			
		  if(typeRecharge.equals("INWI")) {
			 
			  clientMetier.virement(pin, "123", montant);
		}
		  
		  if(typeRecharge.equals("ORANGE")) {
				 
			  clientMetier.virement(pin, "456", montant);
		}
		  if(typeRecharge.equals("MAROCTELE")) {
				 
			  clientMetier.virement(pin, "789", montant);
		}
		}
		catch(Exception e) {
			model.addAttribute("error",e);
		}
		return "redirect:/consulterCompte?codeCompte="+pin;
	}
}
	

