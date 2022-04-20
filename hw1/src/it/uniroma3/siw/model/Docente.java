package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	//nome e il cognome, la data e il luogo di nascita, il numero di partita iva

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String luogoNascita;
	private LocalDate dataNascita;
	private String pIva;
	@OneToMany(mappedBy = "docente")
	private List<Corso> corsi;

	public Docente(String nome, String cognome, String luogoNascita, LocalDate dataNascita, String pIva) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.pIva = pIva;
		this.corsi = new ArrayList<>();

	}
	public Docente(String nome, String cognome, String pIva) {
		this.nome = nome;
		this.cognome = cognome;
		this.pIva = pIva;
		this.corsi = new ArrayList<>();
	}


	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public void addCorso(Corso corso) {
		this.corsi.add(corso);
	}

	public boolean removeCorso(Corso corso) {
		return this.corsi.remove(corso);
	}

	public boolean containsCorso(Corso corso) {
		return this.corsi.contains(corso);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getpIva() {
		return pIva;
	}
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

}
