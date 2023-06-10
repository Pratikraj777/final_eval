package com.pratik.irda.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pratik.irda.entities.PaymentOfClaims;


public interface PaymentOfClaimsRepo extends JpaRepository<PaymentOfClaims, Integer>{
	
    
    @Query("select p from PaymentOfClaims p where p.month= :mon and p.year= :year")
    List<PaymentOfClaims> getPaymentOfClaimsByMonthAndYear(@Param("mon") String month, @Param("year") int year);
}
