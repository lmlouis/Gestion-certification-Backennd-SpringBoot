package dev.lmlouis.Gestioncertifications.models;




public class CertificatModel {

    private String certificatIntittule;
    private String certificatDate;
    private String certificatText="";
    private Boolean certifcatIsvalided=false;
    private String certificatURL;

    public Boolean getCertifcatIsvalided() {
        return certifcatIsvalided;
    }

    public void setCertifcatIsvalided(Boolean certifcatIsvalided) {
        this.certifcatIsvalided = certifcatIsvalided;
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
