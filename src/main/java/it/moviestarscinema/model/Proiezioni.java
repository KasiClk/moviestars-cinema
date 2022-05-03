package it.moviestarscinema.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Proiezioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int codproiezione;
	private double incasso;
	private Date dataproiezione;

	@OneToOne
	private Sala sala;

	@OneToOne
	private Film film;

	public Proiezioni() {
	}

	public Proiezioni(double incasso, Date dataproiezione, Sala sala, Film film) {
		this.incasso = incasso;
		this.dataproiezione = dataproiezione;
		this.sala = sala;
		this.film = film;
	}

	public Proiezioni(int codproiezione, double incasso, Date dataproiezione, Sala sala, Film film) {
		this.codproiezione = codproiezione;
		this.incasso = incasso;
		this.dataproiezione = dataproiezione;
		this.sala = sala;
		this.film = film;
	}

	@Override
	public String toString() {
		return "Proiezioni [codproiezione=" + codproiezione + ", incasso=" + incasso + ", dataproiezione="
				+ dataproiezione + ", sala=" + sala + ", film=" + film + "]";
	}

	public int getCodproiezione() {
		return codproiezione;
	}

	public void setCodproiezione(int codproiezione) {
		this.codproiezione = codproiezione;
	}

	public double getIncasso() {
		return incasso;
	}

	public void setIncasso(double incasso) {
		this.incasso = incasso;
	}

	public Date getDataproiezione() {
		return dataproiezione;
	}

	public void setDataproiezione(Date dataproiezione) {
		this.dataproiezione = dataproiezione;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
