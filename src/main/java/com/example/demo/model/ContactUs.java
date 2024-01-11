package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contactus")
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer u_id;
	@Column(name="user_firstname")
	private String user_firstname;
	@Column(name="user_lastname")
	private String user_lastname;
	@Column(name="user_phonenumber")
	private String user_phonenumber;
	@Column(name="u_email")
	private String u_email;
	@Column(name="u_message")
	private String u_message;
	@Column(name="u_products")
	private String u_products;
	
	public String getU_products() {
		return u_products;
	}
	public void setU_products(String u_products) {
		this.u_products = u_products;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public String getUser_phonenumber() {
		return user_phonenumber;
	}
	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_message() {
		return u_message;
	}
	public void setU_message(String u_message) {
		this.u_message = u_message;
	}
}
