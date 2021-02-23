package com.musicalbumcollection.sevices;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.musicalbumcollection.model.Music;
import com.musicalbumcollection.dao.MusiccollectionDAO;

public class UserService extends UserDetailsService {
             
	 Music save(Music music);

}