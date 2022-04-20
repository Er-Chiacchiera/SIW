package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {

	//Ogni allievo è dipendente di una ed una sola società
	//e può essere iscritto ad uno o più corsi

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private Integer matricola;
	private String	luogoNascita;
	private LocalDate dataNascita;
	private String email;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Azienda azienda;
	/*usata una strategia di fetch eager poiché è necessario tenere aggiornata la lista dei corsi*/
	@ManyToMany(mappedBy = "allievi",fetch = FetchType.EAGER)
	private List<Corso> corsi;

	public Allievo(String nome, String cognome, Integer matricola, String luogoNascita, LocalDate dataNascita,
			String email, Azienda azienda) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.email = email;
		
		this.azienda = azienda;
		this.corsi=new ArrayList<Corso>();
	}
	public Allievo(String nome, String cognome, Integer matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.corsi=new ArrayList<Corso>();
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

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}


}