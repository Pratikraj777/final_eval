package com.pratik.irda.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.irda.entities.PaymentOfClaims;
import com.pratik.irda.service.PaymentOfClaimsService;

@RestController
public class PaymentOfClaimsController {

	@Autowired
	PaymentOfClaimsService paymentOfClaimsService;

	@GetMapping("irda/paymentStatus/report/{month}/{year}")
	List getPaymentsOfClaims(@PathVariable String month,@PathVariable int year)
	{
		return  paymentOfClaimsService.getPaymentOfClaims(month,year);
	}
	@PostMapping("/irda/paymentStatus/pull/{month}/{year}")
	PaymentOfClaims addpaymentsOfClaims(@PathVariable String month,@PathVariable int year,@RequestBody PaymentOfClaims paymentOfClaims)
	{
		return paymentOfClaimsService.addPaymentsOfClaims(month, year, paymentOfClaims);
	}

}
