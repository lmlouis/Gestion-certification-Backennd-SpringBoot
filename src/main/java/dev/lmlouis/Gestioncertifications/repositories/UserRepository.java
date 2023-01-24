package dev.lmlouis.Gestioncertifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lmlouis.Gestioncertifications.entities.User;
import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserEmail(String userEmail);
    
    
}
