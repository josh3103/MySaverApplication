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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Company;
import com.mastek.jobapp.entities.Job;


@Component
@Entity
@Table(name="Users")
@XmlRootElement
public class User implements Serializable {
	
	@Value("-1")
	@FormParam("userId")
	private int userId;
	
	@Value("Default User Name")
	@FormParam("userName")
	private String userName;
	
	@Value("Default Password")
	@FormParam("userPassword")
	private String userPassword;
	
	@Value("Default Age")
	@FormParam("userAge")
	private int userAge;
	
	/*@Value("Default Address")
	@FormParam("userAddress")
	private int address;*/
	
	@Value("Default Contact Number")
	@FormParam("contactNumber")
	private int contactNumber;
	
	@Value("0000000")
	@FormParam("salary")
	private int salary;
	
	
	//Relationships
	
	// one to one relationship between user and saverAccount
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FkSaverAccNumber")
	private SaverAccount currentSaver;
	
	// one to one relationship between user and currentAccount
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FkCurrentAccNumber")
	private CurrentAccount currentAccount;
	
	// one to many relationship between user and transaction
	
	private Set<Transaction> transactions = new HashSet<>();
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="currentUser")
	@XmlTransient
	public Set<Transaction> getTransactions() {
		return transactions;
	}
		
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	//getters-setters
	
	
	public SaverAccount getcurrentSaver() {
		return currentSaver;
	}
	
	public void setCurrentSaver(SaverAccount currentSaver) {
		this.currentSaver = currentSaver;
	}
	
	
	//Primary Key
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="userPassword")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Column(name="userAge")
	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	@Column(name="contactNumber")
	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name="salary")
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	public SaverAccount getCurrentSaver() {
		return currentSaver;
	}

	public User() {
		System.out.println("User Created");
	}

	
	
}
