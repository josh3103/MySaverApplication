package com.example.MySaver.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.MySaver.entities.CurrentAccount;
import com.mastek.jobapp.entities.Job;

public interface CurrentAccountRepository extends CrudRepository<CurrentAccount, Integer> {
	
	//@Autowired
	//public List<CurrentAccount> findBySearchParam(@Param("searchParam") String searchParam);


	
	

	/*@Autowired
	public List<Job> fetchJobByCompanyId(@Param("companyId") int companyId);*/


}
