package com.nadhem.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhem.produits.entities.Developer;
import com.nadhem.produits.entities.Logiciel;
import com.nadhem.produits.repos.LogicielRepository;

@Service
public class LogicielServiceImpl implements LogicielService {

	@Autowired
	LogicielRepository logicielRepository;
	
	@Override
	public Logiciel saveLogiciel(Logiciel l) {
		return logicielRepository.save(l);
		
	}

	@Override
	public Logiciel updateLogiciel(Logiciel l) {
		return logicielRepository.save(l);
		
	}

	@Override
	public void deleteLogiciel(Logiciel l) {
		logicielRepository.delete(l);

	}

   @Override
	public void deleteLogicielById(Long id) {
		logicielRepository.deleteById(id);
		
	}

	@Override
	public Logiciel getLogiciel(Long id) {
		return  logicielRepository.findById(id).get();
	
	}

	@Override
	public List<Logiciel> getAllLogiciels() {
		return logicielRepository.findAll();
	}
	
    @Override
	public List<Logiciel> findByNomLogiciel(String nom) {
		return logicielRepository.findByNomLogiciel(nom);
	}

	@Override
	public List<Logiciel> findByNomLogicielContains(String nom) {
		return logicielRepository.findByNomLogicielContains(nom);
	}

	@Override
	public List<Logiciel> findByNomPrix(String nom, Double prix) {
		return logicielRepository.findByNomPrix(nom, prix);
	}
	
	@Override
	public List<Logiciel> findByDeveloper(Developer developer) {
		return logicielRepository.findByDeveloper(developer);
	}

	@Override
	public List<Logiciel> findByDeveloperIdDev(Long id) {
		return logicielRepository.findByDeveloperIdDev(id);
	}

	@Override
	public List<Logiciel> findByOrderByNomLogicielAsc() {
		return logicielRepository.findByOrderByNomLogicielAsc();
	}

	@Override
	public List<Logiciel> trierLogicielsNomsPrix() {
		return logicielRepository.trierLogicielsNomsPrix();
	}


}
