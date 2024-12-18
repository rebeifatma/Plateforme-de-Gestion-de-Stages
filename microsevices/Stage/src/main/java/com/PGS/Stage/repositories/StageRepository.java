package com.PGS.Stage.repositories;

import com.PGS.Stage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    Optional<Stage> findByDescriptionAndTitreAndNom(String description, String stageTitle, String stageSociete);
}