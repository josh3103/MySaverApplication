package com.example.MySaver.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("prototype") // One copy for each test case
@Entity	// Declare class as entity
@Table(name="Transactions") // Declare table name for class
@XmlRootElement
public class Transaction implements Serializable {
	
	@Value("-1")
	@FormParam("transactionId")
	private int transactionId;
	
	@Value("Default Name")
	@FormParam("userName")
	private String userName;
	
	@Value("Default Transaction Type")
	@FormParam("transactionType")
	private String transactionType;
	
	@Value("Default Monthly Bill") 
	@FormParam("monthlyBill")
	private int monthlyBill;
	
	//Relationships
	
	// Many to one relationship between Transaction-SaverAccount 
	private SaverAccount currentSaver;
		
	@ManyToOne
	@JoinColumn(name="FkSaverNumber")
	public SaverAccount getcurrentSaver() {
			return currentSaver;
		}
		
	public void setCurrentSaver(SaverAccount currentSaver) {
			this.currentSaver = currentSaver;
		}
		
	// Many to one relationship between Transaction-CurrentAccount 
	private CurrentAccount currentAccount;
		
	@ManyToOne
	@JoinColumn(name="FkCurrentNumber")
	public CurrentAccount getcurrentAccount() {
			return currentAccount;
		}
		
	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount= currentAccount;
		}
		
	
	// Many to one relationship between Transaction-User 
	private User currentUser;
			
	@ManyToOne
	@JoinColumn(name="FkUserNumber")
	public User getcurrentUser() {
			return currentUser;
		}
			
	public void setCurrentUser(User currentUser) {
		this.currentUser= currentUser;
		}
	
	
	//getters-setters
	
	@Id
	@Column(name = "transactionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	@Column(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="transactionType")
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Column(name="monthlyBill")
	public int getMonthlyBill() {
		return monthlyBill;
	}

	public void setMonthlyBill(int monthlyBill) {
		this.monthlyBill = monthlyBill;
	}
	
	public Transaction() {
		System.out.println("Transaction Created");
	}
	
		
}
