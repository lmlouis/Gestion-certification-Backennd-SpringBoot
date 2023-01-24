package dev.lmlouis.Gestioncertifications.services;

import java.util.List;



import dev.lmlouis.Gestioncertifications.entities.Certificat;

public interface CertificatService {
    void CreateEntitiesCertificat(Certificat entitiesCertificat);
    void UpdateEntitiesCertificat(Certificat entitiesCertificat);
    List<Certificat> GetEntitiesCertificat();
    Certificat FindbyIdEntitiesCertificat(long IdEntitiesCertificat);
    void DeleteByIdEntitiesCertificat(long IdEntitiesCertificat);
    List<Certificat> findCertificat(String Intitule);
    
}
