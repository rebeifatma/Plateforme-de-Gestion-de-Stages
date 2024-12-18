package com.PGS.IAM.repositories;

import com.PGS.IAM.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}