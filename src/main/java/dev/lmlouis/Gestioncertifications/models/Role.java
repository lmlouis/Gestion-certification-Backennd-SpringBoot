package dev.lmlouis.Gestioncertifications.models;

public enum Role {
  ADMIN,UTILISATEUR;

  public String getStringRole() {
    switch(this) {
      case ADMIN:
        return "ADMIN";

      case UTILISATEUR:
        return "UTILISATEUR";

      default:
        return null;
      }
   }
}
