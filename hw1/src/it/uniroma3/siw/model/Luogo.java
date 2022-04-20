package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Luogo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String via;
	private Integer numeroCivico;
	private String comune;
	private Integer cap;
	private String provincia;


	public Luogo(String via, Integer numeroCivico, String comune, Integer cap, String provincia) {
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}


	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public Integer getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(Integer numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public Integer getCap() {
		return cap;
	}
	public void setCap(Integer cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
