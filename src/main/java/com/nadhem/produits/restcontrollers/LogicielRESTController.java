package com.nadhem.produits.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nadhem.produits.entities.Logiciel;
import com.nadhem.produits.service.LogicielService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LogicielRESTController {
	@Autowired
	LogicielService logicielService;
	
	@RequestMapping(path="all",method =RequestMethod.GET)
	public List<Logiciel> getAllLogiciels() {
		return logicielService.getAllLogiciels();
	 } 		
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	//@GetMapping("/getbyid/{id}")
	public Logiciel getLogicielById(@PathVariable("id") Long id) {	
		return logicielService.getLogiciel(id);
    }
	
	@RequestMapping(value="/addprod",method = RequestMethod.POST)
	//@PostMapping("/addprod")
	public Logiciel createLogiciel(@RequestBody Logiciel logiciel) {
		return logicielService.saveLogiciel(logiciel);
	}

	@RequestMapping(value="/updateprod",method = RequestMethod.PUT)
	//@PutMapping("/updateprod")
	public Logiciel updateLogiciel(@RequestBody Logiciel logiciel) {
		return logicielService.updateLogiciel(logiciel);
	}

	@RequestMapping(value="/delprod/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/delprod/{id}")
	public void deleteLogiciel(@PathVariable("id") Long id)
	{
		logicielService.deleteLogicielById(id);
	}
	
	@RequestMapping(value="/prodscat/{idDev}",method = RequestMethod.GET)
	public List<Logiciel> getLogicielsByDevId(@PathVariable("idDev") Long idDev) {
		return logicielService.findByDeveloperIdDev(idDev);
	 }
	
	@GetMapping("/auth")
	Authentication getAuth(Authentication auth)
	{
			return auth;
	}


}
