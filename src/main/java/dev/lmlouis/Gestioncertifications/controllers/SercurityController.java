package dev.lmlouis.Gestioncertifications.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import dev.lmlouis.Gestioncertifications.entities.User;
import dev.lmlouis.Gestioncertifications.models.Client;
import dev.lmlouis.Gestioncertifications.models.Role;
import dev.lmlouis.Gestioncertifications.security.MD5;
import dev.lmlouis.Gestioncertifications.services.CertificatService;
import dev.lmlouis.Gestioncertifications.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/service")
@CrossOrigin(value="*")
public class SercurityController {

    @Autowired
    UserService userService;
    @Autowired
    CertificatService certificatService;

    MD5 encryptionMd5 = new MD5();

    UserController userController =new UserController();

    @PostMapping(value="security/login")
    @ResponseStatus(code = HttpStatus.OK)
    public String login(@RequestBody Client profile) {
        User user = this.userService.findbyEmailEntitiUser(profile.getUserEmail());
        if(user.getUserPassword().equals(encryptionMd5.getMd5(profile.getUserPassword())) ){
            return "Accès accordé pour l'utilisateur "+user.getUserEmail();
        }
        return "Accès refusé, mot de passe ou email incorrecte";
    }


    @PostMapping(value="security/register")
    @ResponseStatus(code = HttpStatus.OK)
    public String register(@RequestBody Client client) {
        if(this.userService.findbyEmailEntitiUser(client.getUserEmail()) == null){
            User user=new User();
            user.setUserEmail(client.getUserEmail()); 
            user.setUserPassword(this.encryptionMd5.getMd5(client.getUserPassword()));
            user.setUserCertificat(this.certificatService.FindbyIdEntitiesCertificat(1));
            user.setUserRole(Role.UTILISATEUR.getStringRole());
            this.userService.CreateEntitiesUser(user); 
            return "Création du compte "+user.getUserEmail()+" réussi avec succès !";  
        }return "Désolé un compte existe déjà avec cet adresse email, veuillez choisir une autre !";  
    }

    @PostMapping(value="security/login/admin")
    @ResponseStatus(code = HttpStatus.OK)
    public String loginAsAdmin(@RequestBody Client profile) {
        User user = this.userService.findbyEmailEntitiUser(profile.getUserEmail());
        if(user.getUserPassword().equals(encryptionMd5.getMd5(profile.getUserPassword())) && user.getUserRole().contains(Role.ADMIN.getStringRole())) {
            return "Accès accordé pour l'administrateur "+user.getUserEmail();
        }
        return "Accès refusé, mot de passe ou email incorrecte.";
    }

    @PostMapping(value="security/register/admin")
    @ResponseStatus(code = HttpStatus.OK)
    public String registerAsAdmin(@RequestBody Client client) {
        if(this.userService.findbyEmailEntitiUser(client.getUserEmail()) == null){
            User user=new User();
            user.setUserEmail(client.getUserEmail()); 
            user.setUserPassword(this.encryptionMd5.getMd5(client.getUserPassword()));
            user.setUserCertificat(this.certificatService.FindbyIdEntitiesCertificat(1));
            user.setUserRole(Role.ADMIN.getStringRole());
            this.userService.CreateEntitiesUser(user); 
            return "Administateur "+user.getUserEmail()+" crée avec succès !";    
        }
        return "Désolé un compte existe déjà avec cet adresse email, veuillez choisir une autre !";
    }
    
}
