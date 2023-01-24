package dev.lmlouis.Gestioncertifications.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.lmlouis.Gestioncertifications.entities.Certificat;
import dev.lmlouis.Gestioncertifications.entities.User;
import dev.lmlouis.Gestioncertifications.models.CertificatModel;

import dev.lmlouis.Gestioncertifications.services.CertificatService;
import dev.lmlouis.Gestioncertifications.services.UserService;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(value="/service")
@CrossOrigin(value="*")
public class CertificatController {




@Autowired
CertificatService certificatService;

@Autowired
UserService userService;
@PostMapping("/certificat")
void createCertificat(@RequestBody CertificatModel certificatModel) {
	Certificat certificat=new Certificat(); 
    certificat.setCertificatIntittule(certificatModel.getCertificatIntittule());
    certificat.setCertificatDate(certificatModel.getCertificatDate());
    certificat.setCertificatText(certificatModel.getCertificatText());
    certificat.setCertifcatIsvalided(certificatModel.getCertifcatIsvalided());
    certificat.setCertificatURL(certificatModel.getCertificatURL());
	
	this.certificatService.CreateEntitiesCertificat(certificat);
}


@PostMapping("/certificat/inscription/{id}")
void inscription(@RequestParam("email") String email, @PathVariable long id) {
	
	User user=this.userService.findbyEmailEntitiUser(email);
	user.setUserCertificat(this.certificatService.FindbyIdEntitiesCertificat(id));
	this.userService.UpdateEntitiesUser(user);
}




@GetMapping("/certificat")
List<Certificat> findAllCertificat(){
    return this.certificatService.GetEntitiesCertificat();	
}
@GetMapping("/certificat/{id}")
Certificat getOneCertificat(@PathVariable long id) {
	return this.certificatService.FindbyIdEntitiesCertificat(id);
}

@PutMapping(value="/certificat/{id}")
public void UpdateOneCertificat(@PathVariable long id,@RequestBody CertificatModel certificatModel) {
    Certificat certificat  = this.getOneCertificat(id); 
    certificat.setCertificatIntittule(certificatModel.getCertificatIntittule());
    certificat.setCertificatDate(certificatModel.getCertificatDate());
    certificat.setCertificatText(certificatModel.getCertificatURL());
    this.certificatService.UpdateEntitiesCertificat(certificat);
}

@PutMapping(value="/certificat/valid/{active}")
public void switchValidity(@PathVariable long id, @RequestBody Boolean active ) {
    Certificat certificat  = this.getOneCertificat(id);
    if(certificat.getCertifcatIsvalided()){
        certificat.setCertifcatIsvalided(active);
    }
    certificat.setCertifcatIsvalided(active);
    this.certificatService.UpdateEntitiesCertificat(certificat);
}



@DeleteMapping(value = "/certificat/{id}")
public void deleteCertificat(@PathVariable Long id) {
    this.certificatService.DeleteByIdEntitiesCertificat(id);
}







}
