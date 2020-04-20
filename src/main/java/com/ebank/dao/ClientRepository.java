package com.ebank.dao;

import com.ebank.entities.Client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select u from Client u where u.nomUtilisateur=?1")
	Client  findByNomUtilisateur(@Param("u")String nomUtilisateur);
}
