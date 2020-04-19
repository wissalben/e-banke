package com.ebank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebank.entities.Operateur;

public interface OperateurRepository extends JpaRepository<Operateur, Long>  {
	

}
