package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bbs")
@RestController
@PreAuthorize("isAuthenticated()")
public class BoardController {
	
	@PreAuthorize("permitAll")
	@GetMapping("/doA")
	public String doA( ) {
		return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	}

	@GetMapping("/doB")
	public String doB( ) {
		return "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
	}
	
	@GetMapping("/doC")
	public String doC( ) {
		return "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
	}
}
