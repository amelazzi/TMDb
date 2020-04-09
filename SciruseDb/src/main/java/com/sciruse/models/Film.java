package com.sciruse.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sciruse.models.Actors;

@Entity
public class Film {
	
	@Id 	
	@Column(unique = true)
	private Integer ID;

	private String title ;
	@Column(columnDefinition="LONGTEXT")
	private String resume;
	private	 String note ;
	private String dateSortie ;
	private String image;
	private String video;
	
	@JsonIgnore
	@ManyToMany (cascade = {CascadeType.ALL})
	@Column(unique = false,nullable = true)
	private List<Film>filmsLiees ;
	
	@ManyToMany (cascade = {CascadeType.ALL})
	private List<Genre>genre = new ArrayList<Genre>();
	
	@JsonIgnore
	@ManyToMany (cascade = {CascadeType.ALL})
	private List<Actors> actors;
	
	@JsonIgnore
	@ManyToMany (cascade = {CascadeType.ALL})
	private List<Comments>comments = new ArrayList<Comments>();
	
	@JsonIgnore
	@ManyToMany (cascade = {CascadeType.ALL})
	private List<Room>rooms = new ArrayList<Room>();


	
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	
	
	public List<Film> getFilmsLiees() {
		return filmsLiees;
	}
	public void setFilmsLiees(List<Film> filmsLiees) {
		this.filmsLiees = filmsLiees;
	}
	public List<Actors> getActors() {
		return actors;
	}
	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}
	public Film() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	public List<Genre> getGenre() {
		return genre;
	}
	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	@Override
	public String toString() {
		return "Film [ID=" + ID + ", title=" + title + ", resume=" + resume + ", note=" + note + ", dateSortie="
				+ dateSortie + ", image=" + image + ", video=" + video + ", filmsLiees=" + filmsLiees + ", genre="
				+ genre + ", actors=" + actors + ", comments=" + comments + ", rooms=" + rooms + "]";
	}
	
	
	
	



}
