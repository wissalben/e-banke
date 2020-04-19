package com.ebank.dao;

import com.ebank.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	@Query("select u from Compte u where u.pin=?1")
	public Compte findByPin(@Param("u")String pin);
}
