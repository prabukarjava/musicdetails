package com.musicalbumcollection.sevices;



import com.musicalbumcollection.sevices.UserService;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.musicalbumcollection.dao.MusiccollectionDAO;
import com.musicalbumcollection.model.Music;
import com.musicalbumcollection.model.Role;
import com.musicalbumcollection.repository.MusicRepository;


public class UserServiceImpl implements UserService{
	
	private MusicRepository musicRepository;
    

	public UserServiceImpl(MusicRepository musicRepository) {
		super();
		this.musicRepository=musicRepository;
	}
	
	
	public Music save(Music music) {
		MusiccollectionDAO musiccollectionDAO;
		Music music = new Music(musiccollectionDAO.getAlbumname(),
				musiccollectionDAO.getDate(), musiccollectionDAO.getGenre(),musiccollectionDAO.getDescription(),
				musiccollectionDAO.getPrice());
		
		
		return musicRepository.save(music);
	}
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	
		Music music=musicRepository.findBYusername(String albumname);
		if(music == null) {
			throw new UsernameNotFoundException("Invalid username.");
		}
		return new org.springframework.security.core.userdetails.Music(music.getAlbumname(), music.getGenre(), mapRolesToAuthorities(music.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return (Collection<? extends GrantedAuthority>) roles.stream().map(role -> new SimpleGrantedAuthority(role.getAlbumname())).collect(Collectors.toList());
	}

}
