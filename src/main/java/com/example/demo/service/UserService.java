package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContactUs;
import com.example.demo.model.User;
import com.example.demo.repository.ContactUsRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContactUsRepository contactusRepository;
	
	
	public List<User> getAllUser(){
		//Iterable<User> entities = userRepository.findAll();
		ArrayList<User> user = new ArrayList<User>();
		userRepository.findAll().forEach(user1 -> user.add(user1));
		return user;	
	}
	
	public List<ContactUs> getAllcontact(){
		//Iterable<User> entities = userRepository.findAll();
		ArrayList<ContactUs> contactus = new ArrayList<ContactUs>();
		contactusRepository.findAll().forEach(user1 -> contactus.add(user1));
		return contactus;	
	}
	
	public User findbyname(String name,String pass) {
		return userRepository.findbyname(name,pass);
	}
	public void save1(User userrole) {
		// TODO Auto-generated method stub
		userRepository.save(userrole);
	}
	public User getuser(int id) {
		return userRepository.findById(id).get();
	}
	public void save(User user) {
		userRepository.save(user);
	}
	public void saveus(ContactUs contactus) {
		contactusRepository.save(contactus);
	}
}
