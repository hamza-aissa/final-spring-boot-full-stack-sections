package com.nadhem.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nadhem.produits.entities.Developer;

@RepositoryRestResource(path = "dev")
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
