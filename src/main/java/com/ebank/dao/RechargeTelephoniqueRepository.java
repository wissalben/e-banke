package com.ebank.dao;


import com.ebank.entities.RechargeTelephonique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RechargeTelephoniqueRepository extends JpaRepository<RechargeTelephonique, Long> {
	
	@Query("select r from RechargeTelephonique r where r.compte.pin=:x order by r.dateRecharge desc")
	public Page<RechargeTelephonique> listRecharge(@Param("x")String codeCpte,Pageable pageable);
}
