/**
 * 
 */
package fr.diginamic.GP3Covoiturage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.ReservationVehiculeDto;
import fr.diginamic.GP3Covoiturage.dto.ReservationVehiculeDtoMapper;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.services.ReservationVehiculeService;

/**
 * @author antPinot
 *
 */

@RestController
@RequestMapping("/rest/reservation-vehicule")
public class ReservationVehiculeController {
	
	@Autowired
	public ReservationVehiculeService reservationVehiculeService;
	
	@PostMapping
	public ReservationVehiculeDto create(@RequestBody ReservationVehiculeDto reservationVehiculeDtoToCreate) {
		ReservationVehicule model = ReservationVehiculeDtoMapper.toModel(reservationVehiculeDtoToCreate);
		reservationVehiculeService.create(model);
		return reservationVehiculeDtoToCreate;
	}
	
	@GetMapping("/{id}")
	public ReservationVehiculeDto read(@PathVariable("id") Integer id) {
		return ReservationVehiculeDtoMapper.toDto(reservationVehiculeService.findById(id));
	}
	
	@PutMapping
	public ReservationVehiculeDto update(@RequestBody ReservationVehiculeDto reservationVehiculeDtoToUpdate) {
		ReservationVehicule model = ReservationVehiculeDtoMapper.toModel(reservationVehiculeDtoToUpdate);
		reservationVehiculeService.update(model);
		return reservationVehiculeDtoToUpdate;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		reservationVehiculeService.delete(id);
	}

}