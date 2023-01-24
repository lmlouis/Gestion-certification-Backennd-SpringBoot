package dev.lmlouis.Gestioncertifications.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.lmlouis.Gestioncertifications.entities.Certificat;
import dev.lmlouis.Gestioncertifications.entities.User;
import dev.lmlouis.Gestioncertifications.services.CertificatService;
import dev.lmlouis.Gestioncertifications.services.UserService;

@RestController
@RequestMapping(value="/service")
@CrossOrigin(value="*")
public class ResearchController {
    @Autowired
    UserService userService;
    @Autowired
    CertificatService certificatService;


    @GetMapping(value="search/isvalidCerticat")
    public List<User> searchUsersIsvalidCertificat(@RequestParam("isvalidCerticat") Boolean isvalidCerticat) {

        List<User> users = new ArrayList<>();
        for (User itrateUser : this.userService.GetEntitiesUser()) {
            if(this.certificatService.FindbyIdEntitiesCertificat(itrateUser.getUserCertificat().getCertificatId()).getCertifcatIsvalided().equals(isvalidCerticat))
            users.add(itrateUser); 
        }
        return users;
    }



    @GetMapping(value="search/user")
    public List<User> searchUsersByName(@RequestParam("name") String name) {

        List<User> users = new ArrayList<>();
        for (User itrateUser : this.userService.GetEntitiesUser()) {
            if(itrateUser.getUserName().toLowerCase().contains(name.toLowerCase())){users.add(itrateUser);} 
        }
        return users;
    }
    

    @GetMapping(value="search/certificat")
    public List<Certificat> SearchCertificatByName(@RequestParam("name") String name) {
        List<Certificat> liste_celistrtificat = new ArrayList<>();
        for (Certificat itrateCertificat : this.certificatService.GetEntitiesCertificat()) {
            if(itrateCertificat.getCertificatIntittule().toLowerCase().contains(name.toLowerCase())){liste_celistrtificat.add(itrateCertificat);} 
        }
        return liste_celistrtificat;
    }
}
