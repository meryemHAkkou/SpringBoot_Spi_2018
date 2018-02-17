package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
	EnseignantBusiness business;
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Enseignant> recupererToutsLesEnseignant() {
		return business.recupererToutsLesEnseignant();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return business.creerEnseignant(enseignantACreer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE  ,value="/{id}")
	public boolean supprimerEnseignantById(@PathVariable Long id) {
		return business.supprimerEnseignantById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> findByNomEnseignant(@PathVariable String nom) {
		return business.RechercherParNomEnseignant(nom);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{noEnseignant}")
	public Enseignant findByNoEnseignant(@PathVariable long noEnseignant) {
		return business.RechercherParNoEnseignant(noEnseignant);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/email/{emailUbo:.+}")
	public List<Enseignant> findByEmailUBO(@PathVariable String emailUbo) {
		return business.RechercherParEmailUbo(emailUbo);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE)
	public boolean supprimerEnseignant(Enseignant enseignant) {
		return business.supprimerEnseignant(enseignant);
	}
	
}
