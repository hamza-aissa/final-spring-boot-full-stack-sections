package com.nadhem.produits.service;

import java.util.List;

import com.nadhem.produits.entities.Developer;
import com.nadhem.produits.entities.Logiciel;

public interface LogicielService {
	
	 Logiciel saveLogiciel(Logiciel l);
	 Logiciel updateLogiciel(Logiciel l);
	 void deleteLogiciel(Logiciel l);
     void deleteLogicielById(Long id);
	 Logiciel getLogiciel(Long id);
	 List<Logiciel> getAllLogiciels();
	 
	 List<Logiciel> findByNomLogiciel(String nom);
	 List<Logiciel> findByNomLogicielContains(String nom);
	 List<Logiciel> findByNomPrix (String nom, Double prix);
	 List<Logiciel> findByDeveloper (Developer developer);
	 List<Logiciel> findByDeveloperIdDev(Long id);
	 List<Logiciel> findByOrderByNomLogicielAsc();
	 List<Logiciel> trierLogicielsNomsPrix();

}
