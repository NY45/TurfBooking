package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Receipt;

public interface ReceiptRepo  extends JpaRepository<Receipt, Long>{

}
