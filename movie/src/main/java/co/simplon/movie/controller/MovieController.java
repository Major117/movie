package co.simplon.movie.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.movie.model.Movie;

@CrossOrigin ("*")
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	private List<Movie> movieList;
	private String about;	
	
	public MovieController() {
		
		Movie interstellar = new Movie("Interstellar" , "Cristopher Nolan", 2014);
		Movie dunkerque = new Movie("Dunkerque" , "Cristopher Nolan", 2017);
		Movie lePrestige = new Movie("Le Prestige" , "Cristopher Nolan", 2006);
		Movie inception = new Movie("Inception" , "Cristopher Nolan", 2010);
		
		Movie shining = new Movie("Shining" , "Stanley Kubrick", 1980);
		Movie docteurFolamour = new Movie("Docteur Folamour" , "Stanley Kubrick", 1964);
		Movie spaceOdysee = new Movie("2001 L'odyssée de l'espace" , "Stanley Kubrick", 1968);
		Movie orangeMecanique = new Movie("Orange Mécanique" , "Stanley Kubrick", 1972);
		
		Movie django = new Movie("Django Unchained" , "Quentin Tarantino", 2013);
		Movie killBill = new Movie("Kill Bill" , "Quentin Tarantino", 2003);
		Movie pulpFiction = new Movie("Pulp Fiction" , "Quentin Tarantino", 1994);
		Movie reservoirDogs = new Movie("Reservoir Dogs" , "Quentin Tarantino", 1992);
		
		Movie affranchis = new Movie("Les Affranchis" , "Martin Scorsese", 1990);
		Movie taxiDriver = new Movie("Taxi Driver" , "Martin Scorsese", 1976);
		Movie lesInfiltres = new Movie("Les Infiltrés" , "Martin Scorsese", 2006);
		Movie casino = new Movie("Casino" , "Martin Scorsese", 1996);
		
		Movie seven = new Movie("Seven" , "David Fincher", 1996);
		Movie fightClub = new Movie("Fight Club" , "David Fincher", 1999);
		Movie zodiac = new Movie("Zodiac" , "David Fincher", 2007);
		Movie socialNetwork = new Movie("The Social Network" , "David Fincher", 2010);
			
		movieList = new ArrayList<Movie> ( Arrays.asList(interstellar,dunkerque, lePrestige, inception, shining, docteurFolamour, spaceOdysee, orangeMecanique, django, killBill, pulpFiction, reservoirDogs, affranchis, taxiDriver, lesInfiltres, casino, seven, fightClub, zodiac, socialNetwork));
		
		about = ("My project returns a film list which contains its title, its director and its release year.");
	}
	
	
	/**
	 * Retourne toutes la liste de Films en format Json.
	 * @return
	 */
	@RequestMapping("/all")
	public List<Movie> getMovieList() {	
		return movieList;
	}
	
	
	
	/**
	 * Retourne une simple phrase qui décrit le projet.
	 * @return
	 */
	@RequestMapping ("/about")
	public String aboutMovie() {
		
		return about;
	}
	
	
	
	
	/**
	 * Permet de rechercher un film grâce a son id et intercepte les erreurs.
	 * @param id
	 * @return
	 */
	@RequestMapping ("/id")
	public ResponseEntity<Movie> getMovieId(@RequestParam( value = "id") int id) {
		
		int search = id;
		
		for (Movie movie : movieList) {
			if (movie.getId() == search) {
				return ResponseEntity.ok(movie);
			}	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	/**
	 * Permet de créer un film et l'ajoute dans la liste.
	 * @param title
	 * @param director
	 * @param years
	 * @return
	 */
	@PostMapping("/add")
	public Movie addMovie(
			@RequestParam(value="title") String title, 
		    @RequestParam(value="director") String director,
		    @RequestParam(value="years") int years) {
		
		Movie addMovie = new Movie(title, director, years);
		
		this.movieList.add(addMovie);
		
		return addMovie;
	}
}
