package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    
    @Column(nullable = false)
    private LocalDateTime startTime;
    
    @Column(nullable = false)
    private LocalDateTime endTime;
    
    @OneToOne(mappedBy = "booking")
    @JsonIgnore
    private Receipt receipt;
   
    @ManyToOne
    @JoinColumn(name = "payment_id")
    @JsonIgnore// Many bookings can have one payment
    private Payment payment;
    @ManyToOne // Many bookings can be associated with one turf
    @JoinColumn(name = "turf_id", nullable = false)
    @JsonIgnore
    private Turf turf;
    
}
