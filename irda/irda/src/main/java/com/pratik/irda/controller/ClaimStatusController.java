package com.pratik.irda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.irda.entities.ClaimStatus;
import com.pratik.irda.service.ClaimStatusService;
@CrossOrigin("http://localhost:4200")

@RestController
public class ClaimStatusController {
    @Autowired
    ClaimStatusService claimStatusService;
    @GetMapping("irda/claimStatus/repot/{month}/{year}")
    List<ClaimStatus> getClaimStatusByMonthYear(@PathVariable String month,@PathVariable int year)
    {
        return claimStatusService.getClaimStatusByMonthYear(month,year);
    }
    
    @GetMapping("irda/claimStatus/pull/<month>/<year>")
    public ClaimStatus getStatusOfClaimsByMonth(@PathVariable String month, @PathVariable int year) {
    	return null;
    }
    
}
