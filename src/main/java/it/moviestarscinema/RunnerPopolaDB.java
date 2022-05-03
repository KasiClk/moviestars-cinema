package it.moviestarscinema;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.moviestarscinema.model.Film;
import it.moviestarscinema.model.Proiezioni;
import it.moviestarscinema.model.Sala;
import it.moviestarscinema.service.FilmService;
import it.moviestarscinema.service.ProiezioniService;
import it.moviestarscinema.service.SalaService;
import it.moviestarscinema.util.BackupWriter;

@Component
public class RunnerPopolaDB implements CommandLineRunner {
	
	@Autowired
	FilmService filmService; 
	
	@Autowired
	ProiezioniService proiezioniService; 
	
	@Autowired
	SalaService salaService; 
	
	@Override
	public void run(String... args) throws Exception {


		Scanner keyboard = new Scanner(System.in);

		printMenu();

		int userCommand = keyboard.nextInt();

		switch (userCommand) {
		case 0:
//			DataBaseUtil.deleteAllProiezioni(); 
//			DataBaseUtil.deleteAllRooms(); 
//			DataBaseUtil.deleteAllFilm(); 
			
			filmService.saveAllFilm(readFilmsFromData()); 
			salaService.saveAllSala(readSaleFromData()); 
			proiezioniService.saveAllProiezioni(readProiezioniFromData()); 
			break; 
		case 1:
			filmService.saveAllFilm(readFilmsFromData());
			System.out.println("Film inserito");
			break;
		case 2:
			proiezioniService.saveAllProiezioni(readProiezioniFromData());
			System.out.println("Proiezione inserita" );
			break;
		case 3:
			salaService.saveAllSala(readSaleFromData());
			System.out.println("Sala inserito" );
			break;
		case 4:
			System.out.println("Inserisci nome citta per la ricerca");
			keyboard.nextLine();
			List<Sala> sale = salaService.getSalaByNomeCitta(keyboard.nextLine());
			for (Sala s_by_citta : sale)
				System.out.println(s_by_citta.toString());
			break;
//		case 5:
//			System.out.println("Inserisci codice film per ricercare proiezioni");
//			keyboard.nextLine();
//			List<Proiezioni> proiezioni = proiezioniService.getProiezioniByCodFilm(keyboard.nextInt());
//			for (Proiezioni p_by_film : proiezioni)
//				System.out.println(p_by_film.toString());
//
//			break;
		case 6:
			System.out.println("Inserisci codice proiezione da eliminare");
			keyboard.nextLine();
			proiezioniService.deleteProiezione(keyboard.nextLong());
			break;
		case 7:
			String filmtable = filmService.getAllFilm().toString(); 
			String saletable = salaService.getAllSala().toString(); 
			String proitable = proiezioniService.getAllProiezioni().toString(); 
			
			BackupWriter.backupFilm(filmtable);
			BackupWriter.backupSale(saletable);
			BackupWriter.backupProiezioni(proitable);
			break;
		default:
			printMenu();
			break;
		}

		keyboard.close();
	}

	public static List<Film> readFilmsFromData() {
		List<Film> films = new ArrayList<Film>();

		films.add(new Film(2022, "Titolo 1", "Nazionalita 2", "Regista 1", "Attore 1,Attore 2", "Genere 1"));
		films.add(new Film(2021, "Titolo 2", "Nazionalita 2", "Regista 3", "Attore 3,Attore 4", "Genere 1"));
		films.add(new Film(2015, "Titolo 3", "Nazionalita 3", "Regista 1", "Attore 2,Attore 1", "Genere 1"));
		films.add(new Film(2015, "Titolo 4", "Nazionalita 3", "Regista 3", "Attore 1,Attore 2", "Genere 3"));
		films.add(new Film(2015, "Titolo 5", "Nazionalita 4", "Regista 5", "Attore 6,Attore 2", "Genere 3"));
		films.add(new Film(2010, "Titolo 6", "Nazionalita 5", "Regista 1", "Attore 9,Attore 4", "Genere 5"));
		films.add(new Film(2015, "Titolo 7", "Nazionalita 2", "Regista 1", "Attore 1,Attore 2", "Genere 1"));
		films.add(new Film(2024, "Titolo 8", "Nazionalita 2", "Regista 3", "Attore 3,Attore 4", "Genere 1"));
		films.add(new Film(2012, "Titolo 9", "Nazionalita 3", "Regista 1", "Attore 2,Attore 1", "Genere 1"));
		films.add(new Film(2011, "Titolo 10", "Nazionalita 3", "Regista 5", "Attore 1,Attore 2", "Genere 3"));
		films.add(new Film(2001, "Titolo 11", "Nazionalita 7", "Regista 6", "Attore 6,Attore 2", "Genere 12"));
		films.add(new Film(2005, "Titolo 12", "Nazionalita 8", "Regista 7", "Attore 9,Attore 4", "Genere 50"));
		films.add(new Film(2005, "Titolo 13", "Nazionalita 3", "Regista 8", "Attore 1,Attore 2", "Genere 1"));
		films.add(new Film(2022, "Titolo 20", "Nazionalita 4", "Regista 2", "Attore 4,Attore 4", "Genere 15"));
		films.add(new Film(2022, "Titolo 30", "Nazionalita 3", "Regista 1", "Attore 4,Attore 1", "Genere 17"));
		films.add(new Film(2022, "Titolo 40", "Nazionalita 3", "Regista 1", "Attore 4,Attore 2", "Genere 3"));
		films.add(new Film(2020, "Titolo 50", "Nazionalita 4", "Regista 55", "Attore 34,Attore 2", "Genere 13"));
		films.add(new Film(2021, "Titolo 60", "Nazionalita 5", "Regista 17", "Attore 1,Attore 4", "Genere 50"));

		return films;
	}

	public static List<Sala> readSaleFromData() {
		List<Sala> sale = new ArrayList<Sala>();

		sale.add(new Sala(1000, "Sala 2", "Pescara"));
		sale.add(new Sala(1000, "Sala 4", "Pescara"));
		sale.add(new Sala(1000, "Sala 6", "Pescara"));
		sale.add(new Sala(1000, "Sala 8", "Roma"));
		sale.add(new Sala(1000, "Sala 9", "Milano"));
		sale.add(new Sala(1000, "Sala 2", "Firenze"));
		sale.add(new Sala(1000, "Sala 4", "Firenze"));
		sale.add(new Sala(1000, "Sala 6", "Napoli"));
		sale.add(new Sala(1000, "Sala 8", "Catania"));
		sale.add(new Sala(1000, "Sala 9", "Cagliari"));
		sale.add(new Sala(1000, "Sala 2", "Roma"));
		sale.add(new Sala(1000, "Sala 4", "Roma"));
		sale.add(new Sala(1000, "Sala 6", "Pescara"));
		sale.add(new Sala(1000, "Sala 8", "Torino"));
		sale.add(new Sala(1000, "Sala 9", "Milano"));

		return sale;
	}

	/*
	 * Proiezioni contieni riferimenti esterni verso Sala e Film, non so quali ID
	 * perÃ² sono presenti nel DB. Devo leggere il SET di chiavi da Sala e Film cosi
	 * posso usare degli ID esisenti nel DB. (Ricorda sono presenti autonumeranti
	 * nei codici)
	 */
	public List<Proiezioni> readProiezioniFromData() {
		List<Proiezioni> proiezioni = new ArrayList<Proiezioni>();

		proiezioni.add(new Proiezioni(123456.89, new Date(165046052L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(1234556.89, new Date(1650464552L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(123456.89, new Date(1650460672L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(555555.89, new Date(1650468972L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(2342342.89, new Date(1650434552L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(122433.89, new Date(165046453552L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(123.89, new Date(16504603452L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(1232346.89, new Date(16504546052L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(1233356.89, new Date(1650423452L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(1234556.89, new Date(1650462352L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(12336.89, new Date(1650236052L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(123556.89, new Date(1652346052L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(13323.89, new Date(16504603452L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(123233346.89, new Date(16504546052L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(12336356.89, new Date(1650423452L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(12334556.89, new Date(16504652352L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(123367.89, new Date(1650236052L), getRandomSala(), getRandomFilm()));
		proiezioni.add(new Proiezioni(1235756.89, new Date(1652346052L), getRandomSala(), getRandomFilm()));


		return proiezioni;
	}

	public static void printMenu() {
		System.out.println("------------------------------");
		System.out.println("0 - Popola intero DB");
		System.out.println("1 - Inserisci Film");
		System.out.println("2 - Inserisci Proiezione");
		System.out.println("3 - Inserisci Sala");
		System.out.println("4 - Cerca sala per città ");
		System.out.println("5 - Cerca proiezione per codice film");
		System.out.println("6 - Elimina proiezione per codice proiezione");
		System.out.println("7 - Backup DataBase");
		System.out.println("------------------------------");
	}

	private  Sala getRandomSala() {
	
		List<Long> sale_keys = new ArrayList<Long>();
		for (Sala f : salaService.getAllSala())
			sale_keys.add(f.getId());

		int indexSala = extractRandomNumber(sale_keys.size());
		return salaService.getSalaById(sale_keys.get(indexSala));
	}

	private  Film getRandomFilm() {
		
		List<Long> film_keys = new ArrayList<Long>();
		for (Film f : filmService.getAllFilm())
			film_keys.add(f.getId());

		int indexFilm = extractRandomNumber(film_keys.size());
		return filmService.getFilmById(film_keys.get(indexFilm));
	}

	private int extractRandomNumber(int max) {
		double min = 0.0;
		return (int) Math.floor(Math.random() * (Math.floor(max - 1) - min + 1) + min);
	}
}

