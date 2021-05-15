package com.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projet.model.Users;
import com.projet.service.Uservice;






@Controller
public class SearchController {
	
	 @Autowired
	    private EventService service;
	 @Autowired
	    private ReservationService rs;
	// @Autowired
	 //	private UserRepository userRepo;
	 @Autowired
	 	private Uservice userService;
	 @Autowired
	 	private BilletRepository br;
	 	private Long idreservation;
	 

	 
	 @RequestMapping("/")
	    public String viewHomePage(Model model, @Param("keyword") String keyword) {
	        List<Event> eventslist = service.listAll(keyword);
	        model.addAttribute("list", eventslist);
	        model.addAttribute("keyword", keyword);
	         
	        return "index";
	    }
	 
	 @RequestMapping("/admin")
	    public String viewHomePageAdmin(Model model, @Param("keyword") String keyword) {
	        List<Event> eventslist = service.listAll(keyword);
	        model.addAttribute("list", eventslist);
	        model.addAttribute("keyword", keyword);
	         
	        return "indexAdmin";
	    }
	 @GetMapping("/users")
	 public String listUsers(Model model) {
	     List<Users> listUsers =userService.listAll();// userRepo.findAll();
	     model.addAttribute("listUsers", listUsers);
	      
	     return "users";
	 }
	 
	 @GetMapping("/users/edit/{id}")
	 public String editUser(@PathVariable("id") Long id , Model model) {
		 Users user = userService.get(id);
		 
		 model.addAttribute("user",user);
		
		 return "user_form";
	 }
	 
	 @PostMapping("/users/save")
	 public String saveUser(Users user) {
		 userService.saveUserWithDefaultRole(user);
		 return "redirect:/users";
	 }
	 
	 @RequestMapping("/new")
	 public String showNewProductPage(Model model, Event ev) {
	   
	     	
			model.addAttribute("event", new Event());
			model.addAttribute("events",service.findAll());
			return "newEvent";
	 }
	 
	
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String saveEvent(@ModelAttribute("event") Event ev) {
	     service.save(ev);
	      
	     return "redirect:/admin";
	 }
	 
	 @RequestMapping("/edit/{id}")
		public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
			ModelAndView mav = new ModelAndView("edit");
			Event event = service.get(id);
			mav.addObject("event", event);
			
			return mav;
		}
	 
	 @RequestMapping("/reserve/{id}")
	 public String Reserve(Model model,@PathVariable(name = "id") Long id) {
		 
		 model.addAttribute("reservation", new Reservation());
		 this.idreservation=id;
			/*
			 * List<User> Users = userService.listAll();//this.userRepo.findAll();
			 * 
			 * for(User u:Users) {
			 * 
			 * if (u != null) { System.out.println("Found User: " + u); Event
			 * e=service.get(id); Reservation r =new Reservation(u,e); rs.save(r); }
			 * 
			 * 
			 * }
			 */
			return "reservation";
	 }
	 
	 @RequestMapping("/payer/{id}")
	 public String pay(@PathVariable(name = "id") Long id) {
		 

		List<Users> Users =userService.listAll(); // this.userRepo.findAll();
		
		for(Users u:Users) {
		 
	        if (u != null) {
	             System.out.println("Found User: " + u);
	             Event e=service.get(id);
	             Billet b =new Billet(u,e);
	             br.save(b);
	        }
	 
	       
		}
			return "confirmPayment";
	 }
	 
	 @RequestMapping("/login")
	 public String login() {
		 
		 return "login";
	 }
	 
	 @GetMapping("/register")
	 public String showRegistrationForm(Model model) {
	     model.addAttribute("user", new Users());
	      
	     return "register";
	 }
	 
	 @PostMapping("/process_register")
	 public String processRegister(Users user) {
		 userService.saveUserWithDefaultRole(user);
	      
	     return "register_success";
	 }
	 
	
	 
		 @GetMapping("/detailEvent/{id}")
		 
			public String detail(@PathVariable("id") Long id_event , Model model){

				try {
					Event e = service.detail(id_event);
					model.addAttribute("event",e);

				} catch (Exception e) {
					model.addAttribute("excection",e);
				}

				return "showEvent";

			}
	 
	 @RequestMapping(value = "/detail", method = RequestMethod.POST)
	 public String saveReservation(@ModelAttribute("reservation") Reservation reserv) {
		 
		 Event e=service.get(idreservation);
		 	reserv.setEvent(e);
		 	if(reserv.getAge()<25.0) {
		 		reserv.setPrix(50);
		 	}
		 	else {
		 		reserv.setPrix(100);

		 	}
		 	
		 	
			  
			rs.save(reserv);
	      
	     return "confirmReservation";
	 }
	 
	 
	 
	 
	 @RequestMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable(name = "id") Long id) {
	     service.delete(id);
	     return "redirect:/admin";       
	 }
	 
	 @RequestMapping("/searchbyString")
		public String searchstring(Model model,@Param("keyword") String keyword){

	        List<Event> eventslist = service.listAll(keyword);
	        model.addAttribute("list", eventslist);
	        model.addAttribute("keyword", keyword);
	         
	        return "rechercheString";
		}

	 @RequestMapping("/rechercheDate")
		public String searchd(Model model,@Param("date1") String date1, @Param("date2") String date2) throws ParseException{

		 Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(date1); 
			Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dateTime1 = LocalDate.parse(date1, formatter);
			LocalDate dateTime2 = LocalDate.parse(date2, formatter);
	        List<Event> eventslist = service.listEventDate(dateTime1, dateTime2);
	        model.addAttribute("listdate", eventslist);
	        model.addAttribute("date1", d1);
	        model.addAttribute("date2", d2);
	        
	         
	        return "rechercheDate";
		}
	
	 
	 @RequestMapping("/searchbydate")
		public String searchdate(Model model,@Param("date1") String date1, @Param("date2") String date2) throws ParseException{

		 List<Event> eventslist = service.listEventDat(date1, date2);
	        model.addAttribute("list", eventslist);
	        model.addAttribute("date1", date1);
	        model.addAttribute("date2", date1);
	       
	         
	        return "rechercheDate";
		}



	 

}
