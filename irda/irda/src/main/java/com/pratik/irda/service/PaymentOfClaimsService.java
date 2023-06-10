package com.pratik.irda.service;

import com.pratik.irda.entities.PaymentOfClaims;
import com.pratik.irda.repo.ClaimStatusRepo;
import com.pratik.irda.repo.PaymentOfClaimsRepo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentOfClaimsService {

    @Autowired
    PaymentOfClaimsRepo  paymentOfClaimsRepo;
    public List<HashMap<String, Integer>> getPaymentOfClaims(String month,int year)
	{ 	
    	if((month.equalsIgnoreCase("January")) || (month.equalsIgnoreCase("Febuary")) || (month.equalsIgnoreCase("March")) || (month.equalsIgnoreCase("April")) || (month.equalsIgnoreCase("May")) || (month.equalsIgnoreCase("June")) || (month.equalsIgnoreCase("July")) || (month.equalsIgnoreCase("August")) || (month.equalsIgnoreCase("September")) || (month.equalsIgnoreCase("October")) || (month.equalsIgnoreCase("November")) || (month.equalsIgnoreCase("December"))) {
			
	    	    List<PaymentOfClaims> report=paymentOfClaimsRepo.getPaymentOfClaimsByMonthAndYear(month,year);
	    		Map<String, Integer> map=new HashMap<>();
	    		List paymentStatusList=new ArrayList<>();
	        	for (PaymentOfClaims p:report)
	        	{
	        		if(map.containsKey(p.getMonth()))
	        		{
	        			int updatedPayment=map.get(p.getMonth())+p.getPayment();
	        			map.put(p.getMonth(),updatedPayment);
	        		}
	        		else
	        		{
	                map.put(p.getMonth(),p.getPayment());
	        		}
	        	}
	        	
	        	for(Map.Entry<String,Integer> e:map.entrySet())
	        	{
	        		//PaymentOfClaims payemntStatus=new PaymentOfClaims(e.getKey(),e.getValue());
	        		
	            	paymentStatusList.add( e);
	        	}
	        	return paymentStatusList;
	       
		}
    	else
    	{
			throw new RuntimeException("Invalid Month");
    	}
}
    
    public PaymentOfClaims addPaymentsOfClaims(String month,int year,PaymentOfClaims paymentOfClaims)
   
    {
    	paymentOfClaims.setMonth(month);
    	paymentOfClaims.setYear(year);
    	return paymentOfClaimsRepo.save(paymentOfClaims);
    }

}
