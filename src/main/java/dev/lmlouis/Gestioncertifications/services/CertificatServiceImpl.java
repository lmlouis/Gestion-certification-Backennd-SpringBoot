package dev.lmlouis.Gestioncertifications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lmlouis.Gestioncertifications.entities.Certificat;
import dev.lmlouis.Gestioncertifications.repositories.CertificatRepository;
@Service
public class CertificatServiceImpl implements CertificatService{
    @Autowired
	CertificatRepository certificatRepository;

    @Override
    public void CreateEntitiesCertificat(Certificat entitiesCertificat) {
        this.certificatRepository.save(entitiesCertificat);
    }

    @Override
    public void UpdateEntitiesCertificat(Certificat entitiesCertificat) {
        this.certificatRepository.save(entitiesCertificat);
        
    }

    @Override
    public List<Certificat> GetEntitiesCertificat() {
        return this.certificatRepository.findAll();
    }

    @Override
    public Certificat FindbyIdEntitiesCertificat(long IdEntitiesCertificat) {
        return this.certificatRepository.findById(IdEntitiesCertificat).get();
    }

    @Override
    public void DeleteByIdEntitiesCertificat(long IdEntitiesCertificat) {
        this.certificatRepository.deleteById(IdEntitiesCertificat);
        
    }

    @Override
    public List<Certificat> findCertificat(String Intitule) {
        
        return this.certificatRepository.findByCertificatIntittule(Intitule);
    }
    
}
