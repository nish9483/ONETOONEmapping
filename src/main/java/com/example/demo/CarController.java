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
public class CarController {
	@Autowired
	private CarRepo carRepo;
	
	@PostMapping("/cars")
	public ResponseEntity<Car>saveCar(@RequestBody Car car)
	{
		Car c= carRepo.save(car);
		return new ResponseEntity<Car>(c,HttpStatus.CREATED);
	}
	
	@GetMapping("/cars")
	public ResponseEntity<List<Car>>getAllCars()
	{
		List<Car> c= carRepo.findAll();
		return new ResponseEntity<List<Car>>(c,HttpStatus.OK);
	}
	
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car>getCarBYId(@PathVariable int id)
	{
     Optional<Car>c=carRepo.findById(id);
     if(c.isPresent())
     {
    	 return new ResponseEntity<Car>(c.get(),HttpStatus.OK);
     }else
     {
    	 return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
     }
    	 
     }
	@PutMapping("/cars/{id}")
	public ResponseEntity<Car>updateCar(@RequestBody Car updatedCar ,@PathVariable int id)
	{
		Optional<Car>c=carRepo.findById(id);
	     if(c.isPresent())
	     {
	    	 Car ca=c.get();
	    	 ca.setModel(updatedCar.getModel());
	    	 Car car=carRepo.save(ca);
	    	 return new ResponseEntity<Car>(car,HttpStatus.OK);
	     }
	     else
	     {
	    	 return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
	     }
}
	@DeleteMapping("/car/{id}")
	public ResponseEntity<Void>deleteCar(@PathVariable int id)
	{
		Optional<Car>c=carRepo.findById(id);
	     if(c.isPresent())
	     {
	    	 carRepo.deleteById(id);
	    	 return new ResponseEntity<Void>(HttpStatus.OK);
	     }
	     else
	     {
	    	 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	     }
	}
		
	}
