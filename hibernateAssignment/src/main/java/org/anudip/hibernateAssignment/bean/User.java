package org.anudip.hibernateAssignment.bean;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(length = 30)
	private String userName;
	@Column
	private String address;
	@Column
	private Double salary;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String address, Double salary) {
		super();
		this.userName = userName;
		this.address = address;
		this.salary = salary;
	}

	public User(Integer userId, String userName, String address, Double salary) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		String output=String.format("%-5s %-15s %-10s %-10s",userId,userName,address,salary);
		return output;
	}


}
