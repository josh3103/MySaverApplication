package com.example.MySaver.apis;

import java.util.Set;

import javax.inject.Singleton;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.MySaver.entities.CurrentAccount;
import com.example.MySaver.entities.SaverAccount;
import com.example.MySaver.repository.SaverAccountRepository;
import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.entities.User;

@Component
@Scope("singleton")
@Path("/saverAccount/")
public class SaverAccountService {
	
	@Autowired
	private SaverAccountRepository saverAccountRepository;
	
	@Autowired
	private SaverAccount saverAccount;
	
	@POST 
	@Path("/registerCurrentAccount")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public SaverAccount registerOrUpdateSaverAccount(@BeanParam SaverAccount saverAccount) {
	      saverAccount = saverAccountRepository.save(saverAccount);
	      System.out.println("Saver Account Registered "+saverAccount);
	      return saverAccount;
		        
	    }
/*	@GET
	@Path("/find/{SaverAccountId}")
	@Produces({MediaType.APPLICATION_JSON})
	public SaverAccount findBySaverAccountId(@PathParam("SaverAccountId") int SaverAccountId) {
		try {
			return saverAccountRepository.findBySaverAccountId(SaverAccountId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	/*@DELETE
	@Path("/delete/{SaverAccountId}")
	public String deleteJobById(@PathParam("SaverAccountId") int SaverAccountId) {
		 try {
	            saverAccount = findBySaverAccountId(SaverAccountId);
	            
	            Set<User> users = job.getAssignments();
	            job.getAssignments().removeAll(users);
	            
	            job.setCurrentCompany(null);
	           
	            job.setCurrentCompany(null);
	            
	            registerOrUpdateJob(job);
	            jobRepository.deleteById(SaverAccountId);
	            String statement = "Job with Job ID = " + SaverAccountId + " sucessfully deleted";
	            System.out.println(statement);
	            return statement;
		 } catch (Exception e) {
	            e.printStackTrace();
	            String statement = "Job with job ID = " + SaverAccountId + " does not exist";
	            System.out.println(statement);
	            return statement;
	     }
	}*/
	
	public SaverAccountService() {
		System.out.println("Job Service Created");
	}
	
}
