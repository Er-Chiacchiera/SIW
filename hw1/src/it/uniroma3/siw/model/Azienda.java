
package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Azienda {
	//ragione sociale, l’indirizzo della sede (via, numero civico, comune, cap, provincia)
	//il numero di telefono
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ragioneSociale;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Luogo luogo;
	private Integer numeroTelefono;

	public Azienda(String ragioneSociale, Luogo luogo, Integer numeroTelefono) {
		this.ragioneSociale = ragioneSociale;
		this.luogo = luogo;
		this.numeroTelefono = numeroTelefono;
	}
	
	public Azienda(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Luogo getLuogo() {
		return luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


}
