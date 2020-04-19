package com.ebank.dao;

import com.ebank.entities.Client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
	Optional<Client> findById(Long numeroCompte);
	         Client  findByNomUtilisateur(String nomUtilisateur);
}
