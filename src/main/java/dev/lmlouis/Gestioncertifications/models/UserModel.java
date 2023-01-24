package dev.lmlouis.Gestioncertifications.models;



public class UserModel {
    private String userEmail;
    private String userPassword;
    private String userName="Inconnu";
    private String userStatus="Inconnu";
    private String userRole=Role.UTILISATEUR.getStringRole();

    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    /* ----------- OneToMany --------------- 
     * clé étrangère identifiant le certificat
    */
    private long certificatId;


    public long getCertificatId() {
        return certificatId;
    }
    public void setCertificatId(long certificatId) {
        this.certificatId = certificatId;
    }
    /* ----------- OneToMany --------------- */



    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
