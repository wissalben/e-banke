package com.ebank.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebank.entities.Client;
import com.ebank.entities.Compte;
import com.ebank.entities.Operation;
import com.ebank.metier.ClientMetier;

@Controller
public class SecurityController {
	
	
	@Autowired
private ClientMetier clientMetier;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	

}
