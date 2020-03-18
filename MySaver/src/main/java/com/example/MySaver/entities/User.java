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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Value;

import com.mastek.jobapp.entities.Job;


@Entity
@Table(name="User")
@XmlRootElement
public class User implements Serializable {
	
	@Value("-1")
	@FormParam("userId")
	private int userId;
	
	@Value("Default User Name")
	@FormParam("userName")
	private String userName;
	
	@Value("Default Password")
	@FormParam("password")
	private String UserPassword;
	
	public User() {
		System.out.println("User Created");
	}
	
	// many to one relationship
		private Set<Account> group = new HashSet<>();
		
		@ManyToOne(mappedBy = "assignments", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
		public Set<Account> getGroup() {
			return group;
		}
		
		public void setGroup(Set<Account> group) {
			this.group = group;
		}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	
	


}
