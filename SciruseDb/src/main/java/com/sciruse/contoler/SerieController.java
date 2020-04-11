package com.sciruse.contoler;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sciruse.models.Actors;
import com.sciruse.models.Comments;
import com.sciruse.models.Episode;
import com.sciruse.models.Film;
import com.sciruse.models.Genre;
import com.sciruse.models.Saison;
import com.sciruse.models.Serie;
import com.sciruse.repository.ActorRepository;
import com.sciruse.repository.FilmRepository;
import com.sciruse.repository.SerieRepository;
import com.sciruse.service.ImportFunctions;

@RestController
public class SerieController {
	
	private static String Base_url="https://api.themoviedb.org/3/";
	private static String API_Key="94327dc22a17d2c12b806d241682cd96";
	ImportFunctions t;
	@Autowired
	SerieRepository serieRepository;
	
	@Autowired
	ActorRepository ActorRep;
	

	@RequestMapping("/getSeriePopular")
	public List<Serie> getSeriePopular() throws IOException
	{
				
		return (List<Serie>) serieRepository.getSeriePopular();
	}
	
	@RequestMapping("/getSerie/{id}")
	public Serie addAlien(@PathVariable Integer id) throws IOException
	{
		
		return serieRepository.getSerie(id);
	}
	
	
	@RequestMapping("/getSerieActors/{id}")
	public List<Actors> getSerieActors(@PathVariable Integer id) throws IOException
	{
		
		return serieRepository.getSerie(id).getActors();
	}
	
	@RequestMapping("/getSerieComment/{id}")
	public List<Comments> getSerieComment(@PathVariable Integer id) throws IOException
	{
		
		return serieRepository.getSerie(id).getComments();
	}
	
	
	@RequestMapping("/getSerieGenre/{id}")
	public List<Genre> getSerieGenre(@PathVariable Integer id) throws IOException
	{
		
		return serieRepository.getSerie(id).getGenre();
	}
	
	
	@RequestMapping("/getSerieLiees/{id}")
	public List<Serie> getSerieLiees(@PathVariable Integer id) throws IOException
	{
		
		return serieRepository.getSerie(id).getSeriesLiees();
	}
	
	
	@RequestMapping("/getSerieLast")
	public List<Serie> getSerieLast() throws IOException
	{
				
		return (List<Serie>) serieRepository.getSerieLast();
	}
	
	@RequestMapping("/getSerieSaisons/{id}")
	public List<Saison> getSerieSaisons(@PathVariable Integer id) throws IOException
	{
				
		return  serieRepository.getSerie(id).getSaisons();
	}
	
	@RequestMapping("/getSaison/{id}")
	public Saison getSaison(@PathVariable Integer id) throws IOException
	{
				
		return  serieRepository.getSaison(id);
	}
	
	@RequestMapping("/getSaisonEpisodes/{id}")
	public List<Episode> getSaisonEpisodes(@PathVariable Integer id) throws IOException
	{
		return  serieRepository.getSaison(id).getListEpisodes();
	}
	
}
