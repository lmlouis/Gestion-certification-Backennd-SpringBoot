package dev.lmlouis.Gestioncertifications.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificat")
public class Certificat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long certificatId;

    @Column(name = "intittule", nullable = false, unique = true, length = 120)
    private String certificatIntittule;

    @Column(name = "date", nullable = true, length = 40)
    private String certificatDate;

    @Column(name = "description", nullable = true, length = 255)
    private String certificatText;

    private Boolean certifcatIsvalided;

    public Boolean getCertifcatIsvalided() {
        return certifcatIsvalided;
    }

    public void setCertifcatIsvalided(Boolean certifcatIsvalided) {
        this.certifcatIsvalided = certifcatIsvalided;
    }

    @Column(name = "image", nullable = true, length = 255)
    private String certificatURL;
    /* -------------------- OneToMany --------------------------------------
    1 certificat pour * users  => certificat prend une collection de users */
    @JsonBackReference
    @OneToMany(mappedBy="userCertificat")
    Collection<User> certificatUsers=new ArrayList<>();


    public Collection<User> getCertificatUsers() {
        return certificatUsers;
    }

    public void setCertificatUsers(Collection<User> certificatUsers) {
        this.certificatUsers = certificatUsers;
    }
    
    /* -------------------- OneToMany -------------------------------------- */

    public long getCertificatId() {
        return certificatId;
    }

    public void setCertificatId(long certificatId) {
        this.certificatId = certificatId;
    }

    public String getCertificatIntittule() {
        return certificatIntittule;
    }

    public void setCertificatIntittule(String certificatIntittule) {
        this.certificatIntittule = certificatIntittule;
    }

    public String getCertificatDate() {
        return certificatDate;
    }

    public void setCertificatDate(String certificatDate) {
        this.certificatDate = certificatDate;
    }

    public String getCertificatText() {
        return certificatText;
    }

    public void setCertificatText(String certificatText) {
        this.certificatText = certificatText;
    }

    public String getCertificatURL() {
        return certificatURL;
    }

    public void setCertificatURL(String certificatURL) {
        this.certificatURL = certificatURL;
    }



    
    
}
