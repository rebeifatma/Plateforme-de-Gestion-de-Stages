package com.PGS.Stage.repositories;


import com.PGS.Stage.model.StagePFE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagePFERepository extends JpaRepository<StagePFE, Long> {

}