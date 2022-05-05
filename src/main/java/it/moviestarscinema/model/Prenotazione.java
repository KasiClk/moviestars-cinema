package it.moviestarscinema.model;

public class Prenotazione {

	private String id_film;
	private String id_cinema;
	private String id_proiezione;

	public String getId_film() {
		return id_film;
	}

	public void setId_film(String id_film) {
		this.id_film = id_film;
	}

	public String getId_cinema() {
		return id_cinema;
	}

	public void setId_cinema(String id_cinema) {
		this.id_cinema = id_cinema;
	}

	public String getId_proiezione() {
		return id_proiezione;
	}

	public void setId_proiezione(String id_proiezione) {
		this.id_proiezione = id_proiezione;
	}

	@Override
	public String toString() {
		return "Prenotazione [id_film=" + id_film + ", id_cinema=" + id_cinema + ", id_proiezione=" + id_proiezione
				+ "]";
	}

}
