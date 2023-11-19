package cbm.itic.m12.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Oferta {
	@Id // jakarta.persistence.Id
	private long id_oferta;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_empresa", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Empresa empresa;

	@Column(nullable = false, unique = true)
	private String lloc;

	@Column(nullable = false)
	private String jornada;

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oferta(long id_oferta, Empresa empresa, String lloc, String jornada) {
		super();
		this.id_oferta = id_oferta;
		this.empresa = empresa;
		this.lloc = lloc;
		this.jornada = jornada;
	}

	public long getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(long id_oferta) {
		this.id_oferta = id_oferta;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getLloc() {
		return lloc;
	}

	public void setLloc(String lloc) {
		this.lloc = lloc;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	@Override
	public String toString() {
		return "Oferta [id_oferta=" + id_oferta + ", empresa=" + empresa + ", lloc=" + lloc + ", jornada=" + jornada
				+ "]";
	}

}
