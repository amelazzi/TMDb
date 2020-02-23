package com.sciruse.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Film {
	
	@Id @GeneratedValue
	private Integer ID;
	private String tmdb_id;
	private String title ;
	@Column(columnDefinition="LONGTEXT")
	private String resume;
	private	 String note ;
	private String dateSortie ;
	private String duration ;
	private String image;
	//private List<Film>filmsLiees ;
	@ManyToMany (cascade = {CascadeType.ALL})
	private List<Genre>genre = new ArrayList<Genre>();
	//private List<Actors> actors;
	//private List<String>realisator ;
	//private List<Comments>comments ;


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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<Genre> getGenre() {
		return genre;
	}
	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}
	public String getTmdb_id() {
		return tmdb_id;
	}
	public void setTmdb_id(String tmdb_id) {
		this.tmdb_id = tmdb_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Film [ID=" + ID + ", tmdb_id=" + tmdb_id + ", title=" + title + ", resume=" + resume + ", note=" + note
				+ ", dateSortie=" + dateSortie + ", duration=" + duration + ", image=" + image + ", genre=" + genre
				+ "]";
	}
	
	
	



}
