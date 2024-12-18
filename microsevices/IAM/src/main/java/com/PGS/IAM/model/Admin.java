package com.PGS.IAM.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("AD")


public class Admin extends User {
}