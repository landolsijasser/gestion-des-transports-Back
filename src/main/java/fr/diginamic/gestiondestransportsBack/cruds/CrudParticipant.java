package fr.diginamic.gestiondestransportsBack.cruds;

import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.diginamic.gestiondestransportsBack.modeles.Covoiturage;
import fr.diginamic.gestiondestransportsBack.modeles.Participant;
import fr.diginamic.gestiondestransportsBack.modeles.Personne;

public interface CrudParticipant extends CrudRepository<Participant, Integer>{
	
	@Modifying
	@Query("DELETE FROM Participant pa WHERE pa.personne=:personne AND pa.deplacement= :covoiturage")
	void deleteByPersonAndCovoiturage(Personne personne, Covoiturage covoiturage);

	
	@Query("SELECT pa FROM Participant pa WHERE pa.deplacement = :covoiturage")
	Set<Participant> getParticipantByCovoiturage(Covoiturage covoiturage);

}
