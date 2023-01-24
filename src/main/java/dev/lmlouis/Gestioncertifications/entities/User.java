package dev.lmlouis.Gestioncertifications.entities;



import java.io.Serializable;

import dev.lmlouis.Gestioncertifications.models.Role;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;







@Entity
@Table(name = "utilisateur")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long userId;

    @Column(name = "adresse_email", nullable = false, unique = true, length = 45)
    private String userEmail;

    @Column(name = "mot_de_passe", nullable = false, length = 64)
    private String userPassword;

    @Column(name = "nom", nullable = true, length = 120)
    private String userName;
    
    @Column(name = "statut", nullable = true, length = 120)
    private String userStatus;


    @Column(name = "roles", nullable = true, length = 30)
    private String userRole=Role.UTILISATEUR.getStringRole();
    


   public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /* --------------------ManyToOne --------------------------------------
    * users s'inscrivent à 1 certificat  => user contint le certifact */
    //@JsonBackReference
    @ManyToOne
    Certificat userCertificat;

    public Certificat getUserCertificat() {
        return userCertificat;
    }

    public void setUserCertificat(Certificat userCertificat) {
        this.userCertificat = userCertificat;
    }



    /* --------------------ManyToOne --------------------------------------*/

    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }




    

}
