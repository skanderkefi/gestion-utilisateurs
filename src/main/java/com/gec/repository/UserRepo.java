package com.gec.repository;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.gec.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByMatricule(String matricule);
}
