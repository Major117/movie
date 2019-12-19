package co.simplon.movie.model;

public class Movie {

	private int id;
	private String title;
	private String director;
	private int years;
	
	private static int idAuto = 0;                
	
	public Movie(String title, String director, int years) {
		
		this.id = idAuto++;                                                 //permet d'avoir une Id auto increment.
		this.title = title;
		this.director = director;
		this.years = years;
	}


	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getDirector() {
		return director;
	}


	public int getYears() {
		return years;
	}
		
}
