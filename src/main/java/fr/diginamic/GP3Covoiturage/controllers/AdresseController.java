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

import fr.diginamic.GP3Covoiturage.dto.AdresseDto;
import fr.diginamic.GP3Covoiturage.dto.AdresseDtoMapper;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.services.AdresseService;

/**
 * @author antPinot
 *
 */

@RestController
@RequestMapping("/rest/adresse")
public class AdresseController {

	@Autowired
	public AdresseService adresseService;

	/** Create 
	 **
	 * @param adresseToCreate
	 */
	@PostMapping
	public AdresseDto create(@RequestBody AdresseDto adresseToCreate) {
		Adresse model = AdresseDtoMapper.toModel(adresseToCreate);
		adresseService.create(model);
		return adresseToCreate;
	}
	
	@GetMapping("/{id}")
	public AdresseDto read(@PathVariable("id") Integer id) {
		return adresseService.findById(id);
	}

	/**
	 * @param adresseToUpdate
	 */
	@PutMapping
	public AdresseDto update(@RequestBody AdresseDto adresseToUpdate) {
		Adresse model = AdresseDtoMapper.toModel(adresseToUpdate);
		adresseService.update(model);
		return adresseToUpdate;
	}

	/**
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		adresseService.delete(id);
	}

}