package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ContactUs;
import com.example.demo.model.User;
import com.example.demo.model.emailing;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	/*@GetMapping("/")
	private String index1() {
		return "index";
	}*/
	@GetMapping("/index")
	private String index() {
		return "index";
	}
	
	@GetMapping("/Aboutus")
	private String aboutus() {
		return "Aboutus";
	}
	
	@GetMapping("/Contactus")
	private String contactus() {
		return "Contactus";
	}
	
	@GetMapping("/Signin")
	private String signup() {
		return "Signin";
	}
	
	@GetMapping("/loginpage")
	private String signin(){
		return "login";
	}
	@GetMapping("/OurProducts")
	private String listProducts()
	{
		return "OurProducts";
	}
	@PostMapping("/savenew")
	private String saveuser(Map<String,Object> model,User user) {
		//model.put("Userdetails",new User());
		userservice.save(user);
		return "index";
	}
	
	@PostMapping("/contact")
	private String contact(Map<String,Object> model,ContactUs contactus) {
		//model.put("Userdetails",new User());
		emailing email=new emailing();
		email.send_email(contactus);
		userservice.saveus(contactus);
		return "index";
	}
	@GetMapping("/Admin")
	private String getAllUsers(Model model){
		List<ContactUs> contact= userservice.getAllcontact();
		model.addAttribute("contact", contact);
		return "Admin";
	}
	
	@PostMapping("/login/{uid}")
	private User getname(@PathVariable("uid") int uid) {
		return userservice.getuser(uid);
	}
	//@GetMapping("/loginpage")
	//private Model loginpage(){
		//Model model=new Model("login");
		//return "login.jsp";
	//}
	@PostMapping("/submitnew")
	private String submit(@RequestParam("Uname") String name,@RequestParam("pword") String pass,Model model) {
	 String page="";
		model.addAttribute("username",name);
		model.addAttribute("password", pass);
		
		User user = userservice.findbyname(name, pass);	
		System.out.println("userid:"+user.getUsertype());
		if(user.getUsertype().equals("admin"))

				{
					List<ContactUs> contact= userservice.getAllcontact();
					model.addAttribute("contact", contact);
					page="Admin";
					//return "Signin";
				}
		else if(user.getUsertype().equals("user"))
		{
			page="index";
		}
		
		
		return page;
	}
	
	
	/*@PutMapping("/user")
	public void saveUserRole(@RequestBody User userrole) {
		userservice.save(userrole);
		//return userrole;
	}*/
}
