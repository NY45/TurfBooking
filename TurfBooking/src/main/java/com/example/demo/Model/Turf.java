package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "turfs")
public class Turf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "turf_name")
    private String turfName;

    @Column(name = "turf_location")
    private String turfLocation;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private User owner;

    private int capacity;

    @Column(name = "price_per_hour")
    private double pricePerHour;

    @Column(name = "other_info")
    private String otherInfo;
    
    @OneToMany(mappedBy = "turf", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    
    @Override
    public String toString() {
        return "Turf{" +
                "id=" + id +
                ", turfName='" + turfName + '\'' +
                ", turfLocation='" + turfLocation + '\'' +
                ", owner=" + owner +
                ", capacity=" + capacity +
                ", pricePerHour=" + pricePerHour +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
