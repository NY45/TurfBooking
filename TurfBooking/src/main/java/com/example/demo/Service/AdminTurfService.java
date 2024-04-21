package com.example.demo.Service;

import com.example.demo.Model.Turf;
import com.example.demo.Repository.AdminTurfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminTurfService {

    @Autowired
    private AdminTurfRepository turfRepository;

    public List<Turf> getAllTurfs() {
        return turfRepository.findAll();
    }

    public Turf getTurfById(Long id) {
        Optional<Turf> turfOptional = turfRepository.findById(id);
        return turfOptional.orElse(null);
    }

    public Turf updateTurf(Turf turf) {
        return turfRepository.save(turf);
    }

	public Turf createTurf(Turf turf) {
		
		return turfRepository.save(turf);
	}
}
