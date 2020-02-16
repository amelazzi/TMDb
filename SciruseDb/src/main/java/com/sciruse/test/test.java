package com.sciruse.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sciruse.models.Comments;
import com.sciruse.models.Film;
import com.sciruse.models.Genre;
import com.sciruse.models.Actors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class test {


	private final static OkHttpClient httpClient = new OkHttpClient();
	private static String Base_url="https://api.themoviedb.org/3/";
	private static String API_Key="94327dc22a17d2c12b806d241682cd96";

	public static void main(String[] args) {
		Vector<Film>films;
		Vector<Genre>genres;
		Vector<Comments>comments;
		Vector<Actors>actors;
		Actors act;
		try {
			films = MoviesPopular(Base_url+"movie/popular?api_key="+API_Key+"&language=fr&page=1");
			
			//we need to give it the movie id 
			comments = Comment(Base_url+"movie/419704/reviews?api_key="+API_Key+"&language=en-US&page=1");
			actors = Actors(Base_url+"movie/419704/credits?api_key="+API_Key);
			//act = getActorInfo(Base_url+"person/287?api_key="+API_Key+"&language=en-US");
			
			System.out.println(films);
		}catch (Exception e) {System.out.println(e);}


	}

	public static  JSONObject GetMyJson(String url) throws IOException {
		JSONObject object;
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = httpClient.newCall(request).execute()) {

			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

			object = new JSONObject(response.body().string());
		}
		return object;
	}

	public static  Vector<Film> MoviesPopular(String url) throws IOException {

		Vector<Film>films =new Vector<Film>();
		ArrayList<String> listdata;      
		JSONObject movie;

		JSONObject object = GetMyJson(url);

		JSONArray liJsonArray = object.getJSONArray("results");
		String id;
		Film a =null ;
		for (int i = 0; i < liJsonArray.length(); i++) {
			JSONObject obj =(JSONObject) liJsonArray.get(i);
			 id = obj.get("id").toString();
			listdata= new ArrayList<String>();
			a= getFilmInfo(Base_url+"movie/"+id+"?api_key="+API_Key+"&language=fr");
			films.add(a);

		}
		return films; 
	}
	
	
	
	
	
	

//Base_url+"person/287?api_key="+API_Key+"&language=en-US"
	public static  Vector<Actors> Actors(String url) throws IOException {
		Vector<Actors> actors=new Vector<Actors>(); ; 
		String id;
		JSONObject myobj;
		JSONObject object = GetMyJson(url);
		JSONArray actorArray = object.getJSONArray("cast");
		Actors act = null;
		if (actorArray != null) { 
			for (int j=0;j<actorArray.length();j++){ 
				JSONObject obj =(JSONObject) actorArray.get(j);
				 id = obj.get("id").toString();
			
				act = getActorInfo(Base_url+"person/"+id+"?api_key="+API_Key+"&language=fr");
				
				actors.add(act);
			} 
		} 

		return actors;
	}

	//            get/movie/{movie_id}
	public static  Film getFilmInfo(String url) throws IOException {
		Film film = new Film();
		Genre g =null;
		JSONObject myobj;
		JSONObject object = GetMyJson(url);
				     
		film.setTitle(object.get("title").toString());
		film.setTmdb_id(object.get("id").toString());
		film.setResume(object.get("overview").toString());
		film.setDateSortie(object.get("release_date").toString()); 
		film.setImage(object.get("poster_path").toString());
		film.setNote(object.get("vote_average").toString());
		film.setGenre(genre(object));
		 
		return film;
	}

	
	public static  Actors getActorInfo(String url) throws IOException {
		Actors actor = new Actors();
		JSONObject myobj;
		JSONObject object = GetMyJson(url);
		 actor.setDateNaissance(object.get("birthday").toString());  ;
		 actor.setLieuNaissance(object.get("place_of_birth").toString());
		 actor.setNom(object.get("name").toString());
		 actor.setPhoto(object.get("profile_path").toString());
		 actor.setBibliographie(object.get("biography").toString());
		 actor.setPopularite(object.get("popularity").toString());
		 actor.setTdm_id(object.get("id").toString());
		return actor;
	}

	public static  Vector<Comments> Comment(String url) throws IOException {
		Vector<Comments> comments=new Vector<Comments>(); 
		JSONObject myobj;
		JSONObject object = GetMyJson(url);
		JSONArray commment = object.getJSONArray("results");
		Comments com = null;
		if (commment != null) { 
			for (int j=0;j<commment.length();j++){ 
				com =new Comments();
				JSONObject obj =(JSONObject) commment.get(j);
				// System.out.println(obj.get("author").toString());
				com.setUser(obj.get("author").toString());
				com.setText(obj.getString("content").toString());
				comments.add(com);
			} 
		} 

		return comments;
	}

	public static Vector<Genre> genre(JSONObject myJsonObject) throws IOException {
		//https://api.themoviedb.org/3/genre/movie/list?api_key=94327dc22a17d2c12b806d241682cd96&language=fr
		Vector<Genre> genres=new Vector<Genre>(); 
		JSONObject object = myJsonObject;
		JSONArray genreArr = object.getJSONArray("genres");
		Genre g =null;

		if (genreArr != null) { 
			for (int j=0;j<genreArr.length();j++){ 
				g =new Genre();
				JSONObject obj =(JSONObject) genreArr.get(j);
				g.setId(obj.get("id").toString());
				g.setDesig(obj.getString("name").toString());
				genres.add(g);
			} 
		} 

		return genres;
	}
	
	
	
}
