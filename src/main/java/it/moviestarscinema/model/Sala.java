package it.moviestarscinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int codsala;
	private int numero_posti;
	private String nome;
	private String citta;

	public Sala() {
	}

	public Sala(int numero_posti, String nome, String citta) {
		this.numero_posti = numero_posti;
		this.nome = nome;
		this.citta = citta;
	}

	public Sala(int codsala, int numero_posti, String nome, String citta) {
		this.codsala = codsala;
		this.numero_posti = numero_posti;
		this.nome = nome;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Sala [codsala=" + codsala + ", numero_posti=" + numero_posti + ", nome=" + nome + ", citta=" + citta
				+ "]";
	}

	public int getCodsala() {
		return codsala;
	}

	public void setCodsala(int codsala) {
		this.codsala = codsala;
	}

	public int getNumero_posti() {
		return numero_posti;
	}

	public void setNumero_posti(int numero_posti) {
		this.numero_posti = numero_posti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
