package com.ebank;

import com.ebank.dao.*;
import com.ebank.entities.*;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class EBankApplication /*implements CommandLineRunner*/{

	
	 public static void main(String[] args) {
	        SpringApplication.run(EBankApplication.class, args);
	    }


  /*  @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AgenceRepository agenceRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private RechargeTelephoniqueRepository rechargeTelephoniqueRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private OperateurRepository operateurRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ClientRepository clientRepository;
    

    public void run(String... args) throws Exception {

        Compte init = new CompteCourant(null, new BigDecimal(150), false, null,new BigDecimal(0) );
        Admin admin = adminRepository.save(new Admin("admin", "mohamed", "mm", "123456"));
        Agence agence = agenceRepository.save(new Agence("agence1", "adresse", "mlm@452f", "0542545625", "45875526", "ndefkgkr", new Date(), "auto"));
        Agent agent = agentRepository.save(new Agent("Said", "mp", new Date(), "ahrgej", "azfzeg", "azrfe", "azhfef", new Date(), 1600, "cefzg", "iudty", "ydftxd", "iuftdrs", "iydtdg", "ujfjchd", "jcgh", agence));
        Client client = clientRepository.save( new Client("mouad", "azdf", new Date(), "zfaggeg", "1234", "azfere", "azjkrg", "p567", agent, true, new Contrat(new Date())));
        Compte compte = compteRepository.save(new CompteCourant(new Date(), new BigDecimal(1500), true, client, new BigDecimal(150)));
        Compte compte2 = compteRepository.save(new CompteEpargne(new Date(), new BigDecimal(100), true, client, new BigDecimal(2)));
        Operation operation = operationRepository.save(new Versement(new Date(), new BigDecimal(150), compte2));
        Operation operation2 = operationRepository.save(new Retrait(new Date(), new BigDecimal(170), compte2));
        Operation operation3 = operationRepository.save(new Virement(new Date(), new BigDecimal(150), compte, compte2.getCodeCompte()));
        Operateur operateur1=operateurRepository.save(new  Operateur( "inwi", "fgdidfgyusfd"));
        Operateur operateur2=operateurRepository.save(new  Operateur("orange", "fgdidfgyusfd"));
        Operateur operateur3=operateurRepository.save(new  Operateur("maroc telecome", "uisfldiuf"));
    }
  */
}