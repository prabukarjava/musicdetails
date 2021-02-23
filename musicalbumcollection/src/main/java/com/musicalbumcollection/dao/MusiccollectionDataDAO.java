package com.musicalbumcollection.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.musicalbumcollection.model.Music;
import com.musicalbumcollection.repository.MusicRepository;


public class MusiccollectionDataDAO {
	
	@Autowired
	MusicRepository musicRepository;
	
	public Music save(Music mus) {
		return musicRepository.save(mus);
	}
	  
	
	
	/*search*/
	public List<Music> findAll(){
		return musicRepository.findAll();
	}
	
	
	/*get an customer*/
	public Music findOne(Long id) {
		return musicRepository.findOne(id);
	}
	
	/*delete an customer*/
		
		public void delete(Music mus) {
			musicRepository.delete(mus);
		}

}
