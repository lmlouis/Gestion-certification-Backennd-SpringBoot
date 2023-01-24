package dev.lmlouis.Gestioncertifications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lmlouis.Gestioncertifications.entities.Certificat;
import jakarta.transaction.Transactional;

@Transactional
public interface CertificatRepository extends JpaRepository<Certificat, Long>{
    List<Certificat> findByCertificatIntittule(String certificatIntittule);
    
}
