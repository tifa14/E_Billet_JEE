package com.projet;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.projet.model.Role;
import com.projet.repo.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired RoleRepository repo;
	
	@Test
	public void testcreateRoles() {
		Role user = new Role("USER");
		Role admin = new Role("ADMIN");
		repo.saveAll(List.of(user,admin));
		List<Role> listRoles = repo.findAll();
		assertThat(listRoles.size()).isEqualTo(2);
		
	}

}
