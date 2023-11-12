package cbm.itic.m12.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empresa {
	@Id // jakarta.persistence.Id
	private long id;

	@Column(nullable = false, unique = true)
	private String nom;

	@Column(nullable = false)
	private String cif;

	// A PARTIR D'AQUÍ CODI GENERAT DES DEL MENÚ "Source":
	// Els 2 constructors i els getters i setters

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empresa(long id_empresa, String nom, String cif, Set<Oferta> ofertes) {
		super();
		this.id = id_empresa;
		this.nom = nom;
		this.cif = cif;
	}

	public long getId_empresa() {
		return id;
	}

	public void setId_empresa(long id_empresa) {
		this.id = id_empresa;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

//	public Set<Oferta> getOfertes() {
//		return ofertes;
//	}
//
//
//	public void setOfertes(Set<Oferta> ofertes) {
//		this.ofertes = ofertes;
//	}

}
