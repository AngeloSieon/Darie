package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{ 
	
	@Query(value="select * from login u where u.user_name=:name and u.user_password=:pass",nativeQuery=true)
	User findbyname(String name, String pass);
    
	

}
