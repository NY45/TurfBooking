package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Turf;
import com.example.demo.Model.User;
import com.example.demo.Service.AdminTurfService;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/admin/turfs")
public class AdminTurfController {
	
	@Autowired
	private AdminTurfService turfService;
	@Autowired
	private UserService userservice;
	
	@GetMapping
	public ResponseEntity<List<Turf>> getAllTurfs(){
		List<Turf> turfs = turfService.getAllTurfs();
		return new ResponseEntity<>(turfs, HttpStatus.OK);
		
	}
	

	@PostMapping("/createturf/{id}")
	public ResponseEntity<Turf> createTurf(@RequestBody Turf turf,@PathVariable Long id){
		User owner=userservice.getUserById(id);
		turf.setOwner(owner);
		Turf createdTurf = turfService.createTurf(turf);
		
		return new ResponseEntity<>(createdTurf, HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Turf> updateTurfDetails(@PathVariable Long id,@RequestBody Turf updatedTurfDetails){
		
		Turf existingTurf = turfService.getTurfById(id);
		if(existingTurf != null) {
            existingTurf.setTurfName(updatedTurfDetails.getTurfName());
            existingTurf.setTurfLocation(updatedTurfDetails.getTurfLocation());
            existingTurf.setCapacity(updatedTurfDetails.getCapacity());
            existingTurf.setPricePerHour(updatedTurfDetails.getPricePerHour());
            existingTurf.setOtherInfo(updatedTurfDetails.getOtherInfo());
            
            Turf updatedTurf = turfService.updateTurf(existingTurf);
            return new ResponseEntity<>(updatedTurf,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	
	}

}
