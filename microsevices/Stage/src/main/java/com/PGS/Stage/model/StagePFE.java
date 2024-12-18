package com.PGS.Stage.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("PFE")
public class StagePFE extends Stage {

}