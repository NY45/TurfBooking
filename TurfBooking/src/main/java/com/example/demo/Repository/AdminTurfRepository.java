package com.example.demo.Repository;

import com.example.demo.Model.Turf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminTurfRepository extends JpaRepository<Turf, Long> {

}
