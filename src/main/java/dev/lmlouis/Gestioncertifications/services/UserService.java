package dev.lmlouis.Gestioncertifications.services;

import java.util.List;


import dev.lmlouis.Gestioncertifications.entities.User;

public interface UserService {

    void CreateEntitiesUser(User entitiesUser);
    void UpdateEntitiesUser(User entitiesUser);
    List<User> GetEntitiesUser();
    User FindbyIdEntitiesUser(long IdEntitiesUser);
    User findbyEmailEntitiUser(String Email);
    
    
}
