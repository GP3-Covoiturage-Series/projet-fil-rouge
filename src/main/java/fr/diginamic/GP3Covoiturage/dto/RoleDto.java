package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Fekhreddine
 */
public class RoleDto {

	/**
	 * les entites de la classe
	 */

	private Integer id;

	private String name;

	/**
	 * relation many to many avec collaborateur
	 */
	List<CollaborateurDto> collaborateurs = new ArrayList<>();

	/**
	 * @return constructor avec les entites
	 */
	 

	/**
	 * @return constructor vide
	 */
	public RoleDto() {
	}

	public RoleDto(Integer id, String name, List<CollaborateurDto> collaborateurs) {
		super();
		this.id = id;
		this.name = name;
		this.collaborateurs = collaborateurs;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the collaborateurs
	 */
	public List<CollaborateurDto> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<CollaborateurDto> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	/**
	 * 
	 * 
	 *
	 * methode toString
	 */
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + "]";
	}

}
