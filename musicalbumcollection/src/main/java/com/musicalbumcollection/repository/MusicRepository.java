package com.musicalbumcollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.musicalbumcollection.model.Music;


public class MusicRepository extends JpaRepository<Music,Long> {

	public Music save(Music music) {
		
		return null;
	}
	
Music findBYusername(String albumname);


}
