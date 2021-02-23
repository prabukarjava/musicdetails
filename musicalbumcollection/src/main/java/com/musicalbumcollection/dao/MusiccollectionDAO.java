package com.musicalbumcollection.dao;

public class MusiccollectionDAO {
	private Long id;
	private String albumname;
	private String date;
	private String genre;
	private Long price;
	private String description;
	
	public MusiccollectionDAO(Long id, String albumname, String date, String genre, Long price, String description) {
		super();
		this.id = id;
		this.albumname = albumname;
		this.date = date;
		this.genre = genre;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
