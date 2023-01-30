/**
 * 
 */
package fr.diginamic.GP3Covoiturage.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

/**
 * Repository de l'entité ReservationVehicule fournissant des méthodes d'accès à la 
 * base de données
 * @author antPinot
 *
 */

@Repository
public interface ReservationVehiculeRepository extends JpaRepository<ReservationVehicule, Integer> {
	
	/**
	 * Renvoie une liste de réservation de véhicule en fonction de la date de départ de la réservation
	 * 
	 * @param dateDepart
	 * @return liste de ReservationVehicule
	 */
	public List<ReservationVehicule> findByDateDepart(LocalDateTime dateDepart);
	
	/**
	 * Renvoie une liste de réservation de véhicule en fonction de la date de retour de la réservation
	 * 
	 * @param dateRetour
	 * @return liste de ReservationVehicule
	 */
	public List<ReservationVehicule> findByDateRetour(LocalDateTime dateRetour);
	
	/**
	 * Renvoie une liste de réservation de véhicule ayant été faites entre deux dates (de départ)
	 * 
	 * @param dateDepartAnterieure
	 * @param dateDepartPosterieure
	 * @return liste de ReservationVehicule
	 */
	@Query("SELECT r FROM ReservationVehicule r WHERE dateDepart BETWEEN :dateDepartAnterieure AND :dateDepartPosterieure")
	public List<ReservationVehicule> findBetweenDatesDepart(@Param("dateDepartAnterieure")LocalDateTime dateDepartAnterieure, @Param("dateDepartPosterieure")LocalDateTime dateDepartPosterieure);
	
	/**
	 * Renvoie une liste de réservation de véhicule en fonction du collaborateur ayant effectué la réservation
	 * 
	 * @param collaborateur
	 * @return liste de ReservationVehicule
	 */
	public List<ReservationVehicule> findByCollaborateur(Collaborateur collaborateur);
	
	/**
	 * Renvoie une liste de réservation de véhicule associée à un véhicule de société
	 * 
	 * @param vehiculeSociete
	 * @return liste de ReservationVehicule
	 */
	public List<ReservationVehicule> findByVehiculeSociete(VehiculeSociete vehiculeSociete);
	

}