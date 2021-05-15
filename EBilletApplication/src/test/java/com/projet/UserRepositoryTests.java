package com.projet;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.projet.model.Role;
import com.projet.model.Users;
import com.projet.repo.RoleRepository;
import com.projet.repo.UsersRepo;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
  private UsersRepo userRepo;
    
    @Autowired
    private RoleRepository roleRepo;
      
    
    
    @Test
    public void testCreateUser() {
        Users user = new Users();
       user.setUsername("user");
        user.setPassword("123456");
        
         
        Users savedUser = userRepo.save(user);
         
        Users existUser = entityManager.find(Users.class, savedUser.getId());
         
        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
         
    }
  /*  @Test
    public void testFindUserByEmail() {
    	String username = "";
    	Users user = userRepo.findByEmail(email);
    	assertThat(user).isNotNull();
    	
    }*/
    
    @Test
    public void testAddRoleToNewUser() {
    	 Users user = new Users();
    	 
    	 user.setUsername("admin");
         user.setPassword("123456");   
         Role roleUser = roleRepo.findByName("ADMIN");
         user.addRole(roleUser);
         Users savedUser = userRepo.save(user);
         assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }
    
    @Test
    public void testAddRolesToExistingUser() {
    	Users user = userRepo.findById(1L).get();
    	 Role roleUser = roleRepo.findByName("USER");
         user.addRole(roleUser);
         Role roleAdmin = roleRepo.findByName("ADMIN");
         user.addRole(roleAdmin);
         Users savedUser = userRepo.save(user);
         assertThat(savedUser.getRoles().size()).isEqualTo(2); }
   
    
    
}