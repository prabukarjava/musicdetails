package com.musicalbumcollection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicalbumcollection.dao.MusiccollectionDAO;
import com.musicalbumcollection.dao.MusiccollectionDataDAO;
import com.musicalbumcollection.model.Music;




@RestController
@RequestMapping("/musicalbum")
public class MusiccollectionController {
	
	@Autowired
	MusiccollectionDataDAO musiccollectionDataDAO;
	
	@PostMapping("/music")
	public Music createCustomer(@Valid @RequestBody Music mus) {
		return musiccollectionDataDAO.save(mus);
	}
	
	
	@GetMapping("/musicalbum")
	public List<Music> getAllCustomer(){
		return musiccollectionDataDAO.findAll();
	}
	/*get customer by id*/
	@GetMapping("/musicalbum/{id}")
	public ResponseEntity<Music> getEmployeeById(@PathVariable(value="id") Long id){
		
		
		Music mus=musiccollectionDataDAO.findOne(id);
		
		if(mus==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mus);
		
	}
	
	
	@PutMapping("/musicalbum/{id}")
	public ResponseEntity<Music> updateCustomer(@PathVariable(value="id") Long id,@Valid @RequestBody Music musDetails){
		
		Music mus=musiccollectionDataDAO.findOne(id);
		if(mus==null) {
			return ResponseEntity.notFound().build();
		}
		
		
		mus.setAlbumname(musDetails.getAlbumname());
		mus.setAlbumname(musDetails.getDate());
		mus.setAlbumname(musDetails.getDescription());
		mus.setAlbumname(musDetails.getGenre());
		mus.setAlbumname(musDetails.getPrice());;
	
		
		
		Music updateMusic=musiccollectionDataDAO.save(mus);
		return ResponseEntity.ok().body(updateMusic);
		
		
		
	}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Music> deleteMusic(@PathVariable(value="id") Long id){
		
		Music mus=musiccollectionDataDAO.findOne(id);
		if(mus==null) {
			return ResponseEntity.notFound().build();
		}
		musiccollectionDataDAO.delete(mus);
		
		return ResponseEntity.ok().build();
		
		
	}
	
}
