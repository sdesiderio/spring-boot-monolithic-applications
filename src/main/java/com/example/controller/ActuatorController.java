package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.*;

@RestController
@RequestMapping("/test")
public class ActuatorController {
	
	
	@GetMapping
	public List<ActutatorDTO> findAllElements(){
		
		List<ActutatorDTO> elements = new ArrayList<>();
		
		elements.add(new ActutatorDTO("caches","cache",false));
		elements.add(new ActutatorDTO("up","health",true));
		
		return elements;
		
	}

}
