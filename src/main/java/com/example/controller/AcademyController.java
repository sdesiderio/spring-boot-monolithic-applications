package com.example.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Academy;
import com.example.repository.AcademyRepository;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

@RestController
@RequestMapping("/rest/api/academies")
public class AcademyController {
	
	@Autowired
	private AcademyRepository academyRepository;
	
	
	@GetMapping("")
	public List<Academy> findAll(){
		
		return academyRepository.findAll();
	}
	
	@GetMapping("/code/{code}")
	public Optional<Academy> findById(@PathVariable String code){
		
		return academyRepository.findById(code);
	}
	
	@GetMapping("/initial")
	public List<Academy> saveNewAcademy(){
		
		Academy academy = new Academy("1028A","Java SE","Rome");
		
		academyRepository.save(academy);
		
		return academyRepository.findAll();
		
	}
	
	@GetMapping("/clear")
	public void clear()
	{
		HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
		Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();
		for (DistributedObject object : distributedObjects)
		{
			if (object instanceof IMap)
			{
				hazelcastInstance.getMap(object.getName()).destroy();
				System.out.println("Map destroyed=" + hazelcastInstance.getMap(object.getName()).getName());
			}
		}
		hazelcastInstance.shutdown();
	}
	
	
	
	

}
