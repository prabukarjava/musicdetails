package com.musicalbumcollection.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControler {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
