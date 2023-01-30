package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.repositories.VehiculeSocieteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class VehiculeSocieteService {
	
	@Autowired
	public VehiculeSocieteRepository vehiculeSocieteRepository;
	
	public VehiculeSociete create(@Valid VehiculeSociete vehiculeSocieteToCreate) {
		if(vehiculeSocieteToCreate.getId() != null) {
			throw new RuntimeException("Id doit être null");
		}
		return vehiculeSocieteRepository.save(vehiculeSocieteToCreate);
	}
	
	public VehiculeSociete update(@Valid VehiculeSociete vehiculeSocieteToUpdate) {
		if (vehiculeSocieteToUpdate.getId() == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		return vehiculeSocieteRepository.save(vehiculeSocieteToUpdate);
	}
	
	public void delete(Integer id) {
		if(id == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		vehiculeSocieteRepository.deleteById(id);
	}
	
	public VehiculeSociete findById(Integer id) {
		return vehiculeSocieteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<VehiculeSociete> findAll() {
		return vehiculeSocieteRepository.findAll();
	}

}