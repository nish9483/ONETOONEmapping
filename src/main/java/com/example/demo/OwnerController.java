package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
	@Autowired
	private OwnerRepo ownerRepo;
	
	@PostMapping("/owner")
	public ResponseEntity<Owner>saveOwner(@RequestBody Owner owner)
	{
		Owner o= ownerRepo.save(owner);
		return new ResponseEntity<Owner>(o,HttpStatus.CREATED);
	}
	
	@GetMapping("/owner")
	public ResponseEntity<List<Owner>>getAllOwner()
	{
		List<Owner> c= ownerRepo.findAll();
		return new ResponseEntity<List<Owner>>(c,HttpStatus.OK);
	}
	
	
	@GetMapping("/owner/{id}")
	public ResponseEntity<Owner>getOwnerBYId(@PathVariable int id)
	{
     Optional<Owner>c=ownerRepo.findById(id);
     if(c.isPresent())
     {
    	 return new ResponseEntity<Owner>(c.get(),HttpStatus.OK);
     }else
     {
    	 return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
     }
    	 
     }
	@PutMapping("/owner/{id}")
	public ResponseEntity<Owner>updateOwner(@RequestBody Owner updatedOwner ,@PathVariable int id)
	{
		Optional<Owner>c=ownerRepo.findById(id);
	     if(c.isPresent())
	     {
	    	 Owner ca=c.get();
	    	 ca.setName(updatedOwner.getName());
	    	 ca.setCity(updatedOwner.getCity());
	    	 Owner owner=ownerRepo.save(ca);
	    	 return new ResponseEntity<Owner>(owner,HttpStatus.OK);
	     }
	     else
	     {
	    	 return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
	     }
}
	@DeleteMapping("/owner/{id}")
	public ResponseEntity<Void>deleteOwner(@PathVariable int id)
	{
		Optional<Owner>c=ownerRepo.findById(id);
	     if(c.isPresent())
	     {
	    	 ownerRepo.deleteById(id);
	    	 return new ResponseEntity<Void>(HttpStatus.OK);
	     }
	     else
	     {
	    	 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	     }
	}
		
	}



