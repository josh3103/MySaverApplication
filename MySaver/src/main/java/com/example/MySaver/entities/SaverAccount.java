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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Job;


@Component
@Scope("prototype") // One copy for each test case
@Entity	// Declare class as entity
@Table(name="SaverAccount") // Declare table name for class
@XmlRootElement
public class SaverAccount implements Serializable {
	
	@Value("-1")
	@FormParam("SaverAccountId")
	private int SaverAccountId;
	
	@Value("000000")
	@FormParam("SaverAccountNo")
	private int SaverAccountNo;
	
	@Value("00000")
	@FormParam("weeklySaver")
	private int weeklySaver;
	
	
	@Value("Default Name")
	@FormParam("accountName")
	private String accountName;
	
	
	
	//	Relationships
	
	// One-to-one SaverAccount-User
	@OneToOne(mappedBy="FkSaverNumber")
	private User user;
	
	// One-to-Many SaverAccount-Transaction
	private Set<Transaction> transactions = new HashSet<>();
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="currentTransaction")
	@XmlTransient
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	
	
	//	getters-setters
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}


	@Id // Declare as Primary Key
	@Column(name="saverAccountId") // Declare name of column
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto-numbering
	public int getSaverAccountId() {
		return SaverAccountId;
	}

	public void setSaverAccountId(int saverAccountId) {
		this.SaverAccountId = saverAccountId;
	}
	
	@Column(name="saverAccountNo")
	public int getSaverAccountNo() {
		return SaverAccountNo;
	}

	public void setSaverAccountNo(int saverAccountNo) {
		SaverAccountNo = saverAccountNo;
	}
	
	@Column(name="weeklySaver")
	public int getWeeklySaver() {
		return weeklySaver;
	}

	public void setWeeklySaver(int weeklySaver) {
		this.weeklySaver = weeklySaver;
	}
	
	@Column(name="accountName")
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
/*	@Override
	public String toString() {
		return "SaverAccount [SaverAccountId=" + SaverAccountId + ", accountName=" + accountName + "]";
	}*/
	
	public SaverAccount() {
		System.out.println("Saver Account Created");
	}
	
	

}
