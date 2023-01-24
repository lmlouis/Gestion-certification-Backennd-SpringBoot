package dev.lmlouis.Gestioncertifications.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.lmlouis.Gestioncertifications.entities.User;
import dev.lmlouis.Gestioncertifications.models.UserModel;
import dev.lmlouis.Gestioncertifications.services.CertificatService;
import dev.lmlouis.Gestioncertifications.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value="/service")
@CrossOrigin(value="*")
public class UserController {




@Autowired
UserService userService;
@Autowired
CertificatService certificatService;


@PostMapping("/user")
void createUser(@RequestBody UserModel userModel) {
	User user=new User();
	user.setUserEmail(userModel.getUserEmail()); 
    user.setUserPassword(userModel.getUserPassword());
    user.setUserName(userModel.getUserName());
    user.setUserStatus(userModel.getUserStatus());
	user.setUserCertificat(this.certificatService.FindbyIdEntitiesCertificat(userModel.getCertificatId()));
	
	this.userService.CreateEntitiesUser(user);
}


@GetMapping("/user")
List<User> findAllUsers(){
return this.userService.GetEntitiesUser();	
}
@GetMapping("/user/{id}")
User getOneUser(@PathVariable long id) {
	return this.userService.FindbyIdEntitiesUser(id);
}

@PutMapping(value="/user/{id}")
public void UpdateOneUser(@PathVariable long id,@RequestBody UserModel userModel) {
    User userToUpdate = this.userService.FindbyIdEntitiesUser(id);
    userToUpdate.setUserEmail(userModel.getUserEmail()); 
    userToUpdate.setUserPassword(userModel.getUserPassword());
    userToUpdate.setUserName(userModel.getUserName());
    userToUpdate.setUserStatus(userModel.getUserStatus());
    this.userService.UpdateEntitiesUser(userToUpdate);
}

@GetMapping(value = "/user/profile")
public User FindProfileByEmail(@RequestParam("email") String email){
    return this.userService.findbyEmailEntitiUser(email);}




    
}
