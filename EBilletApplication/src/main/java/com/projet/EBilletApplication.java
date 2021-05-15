package com.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.projet.model.Users;
import com.projet.repo.UsersRepo;


@SpringBootApplication
public class EBilletApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(EBilletApplication.class, args);
		EventRepository repo=ctx.getBean(EventRepository.class);
		
		
		Event e=new Event("fete foraine","Orleans","22/3/2021","fete foraine","ggggggg");
		repo.save(new Event("foire","Paris","21/05/2010","musical","ggggggg"));
		repo.save(new  Event("fete de noel","Tours","25/12/2021","musical","ggggggg"));
		
		repo.save(new Event("foire","Paris","21/05/2010","musical","ggggggg"));
		repo.save(new  Event("fete de noel","Tours","25/12/2021","musical","ggggggg"));

		repo.save(e);
		
		
		
		
		
		
		  
		UsersRepo userRepo=ctx.getBean(UsersRepo.class);
		
		
		//Users admin=new Users("admin", "admin",true);
		
		
		
		//userRepo.save(admin);
		
		
		
		
		
		
	}

}
