package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController
@RequestMapping("/formations")
public class FormationController {

	private FormationBusiness business;

	@Autowired
	public FormationController(FormationBusiness business) {
		this.business = business;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{codeFormation}")
	public boolean supprimerFormationById(@PathVariable String codeFormation) {
		return business.supprimerFormationById(codeFormation);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}")
	public Formation chercherFormationParId(@PathVariable String codeFormation) {
		return business.chercherFormationParId(codeFormation);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Formation creerFormation(@RequestBody Formation formationACreer) {
		return business.creerFormation(formationACreer);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> recupererToutesLesFormations() {
		return business.recupererToutesLesFormationsFormation();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean supprimerFormation(@RequestBody Formation formationASuprimer) {
		return business.supprimerFormation(formationASuprimer);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/nom/{nomFormation}")
	public List<Formation> recupererLaFormationAvecLeNom(@PathVariable String nomFormation) {
		return business.findByNomFormation(nomFormation);
	}

}
