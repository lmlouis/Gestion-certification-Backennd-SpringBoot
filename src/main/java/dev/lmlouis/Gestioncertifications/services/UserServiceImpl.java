package dev.lmlouis.Gestioncertifications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lmlouis.Gestioncertifications.entities.User;
import dev.lmlouis.Gestioncertifications.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    

    @Override
    public void CreateEntitiesUser(User entitiesUser) {
        this.userRepository.save(entitiesUser);
        
    }

    @Override
    public void UpdateEntitiesUser(User entitiesUser) {
        this.userRepository.save(entitiesUser);
        
    }

    @Override
    public List<User> GetEntitiesUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User FindbyIdEntitiesUser(long IdEntitiesUser) {
        return this.userRepository.findById(IdEntitiesUser).get();
    }

    @Override
    public User findbyEmailEntitiUser(String Email) {
        return this.userRepository.findByUserEmail(Email);
    }

  
  
    
}
