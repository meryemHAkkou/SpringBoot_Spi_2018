package fr.univbrest.dosi.business;

import java.util.List;


import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {

	Enseignant creerEnseignant(Enseignant enseignantACreer);

	boolean supprimerEnseignantById(Long id);

	boolean supprimerEnseignant(Enseignant enseignant);

	Enseignant RechercherParNoEnseignant(long noEnseignant);

	List<Enseignant> recupererToutsLesEnseignant();

	List<Enseignant> RechercherParNomEnseignant(String nom);

	List<Enseignant> RechercherParEmailUbo(String emailUbo);

}
