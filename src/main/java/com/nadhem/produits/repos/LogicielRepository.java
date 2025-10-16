package com.nadhem.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nadhem.produits.entities.Developer;
import com.nadhem.produits.entities.Logiciel;

public interface LogicielRepository extends JpaRepository<Logiciel, Long> {
  List<Logiciel> findByNomLogiciel(String nom);

  List<Logiciel> findByNomLogicielContains(String nom);

  @Query("select l from Logiciel l where l.nomLogiciel like %:nom and l.prixLogiciel > :prix")
  List<Logiciel> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

  @Query("select l from Logiciel l where l.developer = ?1")
  List<Logiciel> findByDeveloper(Developer developer);

  List<Logiciel> findByDeveloperIdDev(Long id);

  List<Logiciel> findByOrderByNomLogicielAsc();

  @Query("select l from Logiciel l order by l.nomLogiciel ASC, l.prixLogiciel DESC")
  List<Logiciel> trierLogicielsNomsPrix();

}
