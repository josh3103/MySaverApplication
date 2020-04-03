package com.example.MySaver.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

	@Component
    @Entity
    @Table(name="CurrentAccount")    
    //@EntityListeners({UserLifeCycleListener.class})
    @XmlRootElement
    public class CurrentAccount implements Serializable {
        
        @Value("-1")
        @FormParam("currentAccountId")
        private int currentAccountId;
        
        @Value("Default value")
        @FormParam("currentAccountNumber")
        private int currentAccountNumber;
        
        @Value("Default value")
        @FormParam("currentAccountSortCode")
        private int currentAccountSortCode;
        
        @Value("Default value")
        @FormParam("currentAccountExpirationDate")
        private String currentAccountExpirationDate;
        
        @Value("Default value")
        @FormParam("availableBalance")
        private double availableBalance;
        
        @Value("Default value")
        @FormParam("arrangedOverdraft")
        private double arrangedOverdraft;
        
        
        //Relationships
        
        // one to many relationship between currentacc and transaction
    	private Set<Transaction> transactions = new HashSet<>();
    	
    	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="currentTransaction")
    	@XmlTransient
    	public Set<Transaction> getTransactions() {
    		return transactions;
    	}

    	public void setTransactions(Set<Transaction> transactions) {
    		this.transactions = transactions;
    	}
    	
    	// one to one relationship between currentAccount and saverAccount
    	@OneToOne(mappedBy = "currentAccount")
  	  	private SaverAccount saverAccount;
    	
    	public SaverAccount getSaverAccount() {
			return saverAccount;
		}

		public void setSaverAccount(SaverAccount saverAccount) {
			this.saverAccount = saverAccount;
		}
    	
    	// one to one relationship between currentAccount and user
    	@OneToOne(mappedBy = "currentAccount")
    	private User user;
    	
    	public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
    	
		
    	//getters-setters
		
		
    	@Id
    	@Column(name = "currentAccountId")
    	@GeneratedValue(strategy=GenerationType.AUTO)
        public int getCurrentAccountId() {
			return currentAccountId;
		}

		public void setCurrentAccountId(int currentAccountId) {
			this.currentAccountId = currentAccountId;
		}
		
		@Column(name = "currentAccountNumber")
		public int getCurrentAccountNumber() {
			return currentAccountNumber;
		}

		public void setCurrentAccountNumber(int currentAccountNumber) {
			this.currentAccountNumber = currentAccountNumber;
		}


		@Column(name="currentAccountSortCode")
        public int getCurrentAccountSortCode() {
            return currentAccountSortCode;
        }

        public void setCurrentAccountSortCode(int currentAccountSortCode) {
            this.currentAccountSortCode = currentAccountSortCode;
        }

 
        @Column(name="currentAccountExpirationDate")
        public String getCurrentAccountExpirationDate() {
            return currentAccountExpirationDate;
        }
 
        public void setCurrentAccountExpirationDate(String currentAccountExpirationDate) {
            this.currentAccountExpirationDate = currentAccountExpirationDate;
        }

        @Column(name="availableBalance")
        public double getAvailableBalance() {
            return availableBalance;
        }

        public void setAvailableBalance(double availableBalance) {
            this.availableBalance = availableBalance;
        }

        @Column(name="arrangedOverdraft")
        public double getArrangedOverdraft() {
            return arrangedOverdraft;
        }

        public void setArrangedOverdraft(double arrangedOverdraft) {
            this.arrangedOverdraft = arrangedOverdraft;
        }

        
        public CurrentAccount() {
            System.out.println("User Created");
        }
            
    
    
	}

