package com.ebank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


import com.ebank.entities.Operateur;

public interface OperateurRepository extends CrudRepository<Operateur,Long>, QueryByExampleExecutor <Operateur> {
	

}
