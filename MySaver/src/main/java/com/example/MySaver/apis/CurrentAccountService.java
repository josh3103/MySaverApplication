package com.example.MySaver.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
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
import com.example.MySaver.repository.CurrentAccountRepository;

@Component
@Scope("singleton")
@Path("/currentaccounts")
public class CurrentAccountService {
	    
    @Autowired
    private CurrentAccountRepository currentAccountRepository;
	    
    public CurrentAccountService() {
        System.out.println("Current Account Service Created");    
    }

    
    
    
    @POST 
    @Path("/registerCurrentAccount")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public CurrentAccount registerOrUpdateCurrentAccount(@BeanParam CurrentAccount currentAccount) {
        currentAccount = currentAccountRepository.save(currentAccount);
        System.out.println("Current Account Registered "+currentAccount);
        return currentAccount;
	        
    }
	    
	    
	    /*@POST
	    @Path("/updateArrangedOverDraft")
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    @Produces(MediaType.APPLICATION_JSON)
	    
	    public CurrentAccount updateArrangedOverdraft(@BeanParam CurrentAccount currentAccount) {
	        double arrangedOverDraft = currentAccount.getArrangedOverdraft();
	        CurrentAccount existingCurrentAccount = findByCurrentAccountId(currentAccountId);
	        if(arrangedOverDraft != 0) {
	            existingCurrentAccount.setArrangedOverdraft(arrangedOverDraft);
	        }
	        
	        currentAccountRepository.save(existingCurrentAccount);
	        System.out.println("Current Account arranged overdraft updated" + currentAccount);
	        return currentAccount;
	        
	    }    
	    @Path("/find/{currentAccountId}")
	    @GET
	    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    
	    public int findByCurrentAccountId(@PathParam("currentAccountId") int currentAccountId) {
	        try {
	            return currentAccountRepository.findByCurrentAccountId(currentAccountId).getCurrentAccountId();
	        }
	        catch(Exception exception) {
	            exception.printStackTrace();
	        }
	        return currentAccountId;
	    
	        
	    
	    }*/
	    
	   /* @POST
	    @Path("/deleteCurrentAccount")
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    @Produces(MediaType.APPLICATION_JSON)
	    @Transactional
	    
	    public Set<User> deleteUserCurrentAccount(@FormParam("userId") int userId, @FormParam("currentAccountId")
	    int currentAccountId) {
	        try {
	        CurrentAccount currr = new CurrentAccount();
	        
	        currr=findByCurrentAccountId(currentAccountId);
	            
	            
	            
	        }
	        catch {
	            
	            
	        }
	        
	        
	        
	        return null;
	        
	    }*/
	    
	    
	    
	    
	    
	    
	    

	 

	
}
