package com.PGS.IAM.repositories;

import com.PGS.IAM.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long> {

}