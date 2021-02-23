package com.musicalbumcollection.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import com.musicalbumcollection.model.Role;





@Entity
@Table(name="musicdetails")
@EntityListeners(AuditingEntityListener.class)
public class Music {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String albumname;
	@NotBlank
	private String date;
	@NotBlank
	private String genre;
	@NotBlank
	private Long price;
	@NotBlank
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;

	

	

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





	public Collection<Role> getRoles() {
		return roles;
	}





	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}





	public Music(Long id, String albumname, String date, String genre, Long price, String description,
			Collection<Role> roles) {
		super();
		this.id = id;
		this.albumname = albumname;
		this.date = date;
		this.genre = genre;
		this.price = price;
		this.description = description;
		this.roles = roles;
	}





	




	
}
