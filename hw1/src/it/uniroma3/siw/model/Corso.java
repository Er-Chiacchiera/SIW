package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	private LocalDate dataInizio;
	private int durata;
	
	/*usata una strategia di fetch eager poiché è necessario tenere aggiornata la lista degli allievi*/
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Allievo> allievi;
	@ManyToOne
	private Docente docente;

	public Corso (String nome, LocalDate dataInizio, int durata, Docente docente) {
		this.nome=nome;
		this.dataInizio=dataInizio;
		this.durata=durata;
		this.docente=docente;
		this.allievi= new ArrayList<>();

	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public List<Allievo> getAllievi() {
		return allievi;
	}
	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	public void addAllievo (Allievo allievo) {
		this.allievi.add(allievo);
	}
	public boolean removeAllievo (Allievo allievo) {
		return this.allievi.remove(allievo);
	}
	public boolean containsAllievo (Allievo allievo) {
		return this.allievi.contains(allievo);
	}


}
