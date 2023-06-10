package com.pratik.irda.service;

import com.pratik.irda.entities.ClaimStatus;
import com.pratik.irda.entities.PendingStatusReport;
import com.pratik.irda.repo.ClaimStatusRepo;
import com.pratik.irda.repo.PendingStatusReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
@Service
public class ClaimStatusService {
    @Autowired
    PendingStatusReportRepo pendingStatusReportRepo;
    @Autowired
    ClaimStatusRepo claimStatusRepo;

    public List<ClaimStatus> getClaimStatusByMonthYear(String month, int year){
    	if((month.equalsIgnoreCase("January")) || (month.equalsIgnoreCase("Febuary")) || (month.equalsIgnoreCase("March")) || (month.equalsIgnoreCase("April")) || (month.equalsIgnoreCase("May")) || (month.equalsIgnoreCase("June")) || (month.equalsIgnoreCase("July")) || (month.equalsIgnoreCase("August")) || (month.equalsIgnoreCase("September")) || (month.equalsIgnoreCase("October")) || (month.equalsIgnoreCase("November")) || (month.equalsIgnoreCase("December"))) {
    		if(isValidYear(year)){
	    	    List<PendingStatusReport> report=pendingStatusReportRepo.getPendingStatusReportByByMonthAndYear(month,year);
	    		Map<String, Integer> map=new HashMap<>();
	    		List<ClaimStatus> claimStatuses=new ArrayList<>();
	        	for (PendingStatusReport p:report)
	        	{
	        		if(map.containsKey(p.getStage()))
	        		{
	        			int count=map.get(p.getStage())+p.getCount();
	        			map.put(p.getStage(),count);
	        		}
	        		else
	        		{
	                map.put(p.getStage(),p.getCount());
	        		}
	        	}
	        	int i=0;
	        	for(Map.Entry<String,Integer> e:map.entrySet())
	        	{
	        		ClaimStatus claimStatus=new ClaimStatus(e.getKey(),e.getValue());
	        		claimStatus.setId((long) ++i);
	            	claimStatuses.add(claimStatus);
	        	}
	        	return claimStatusRepo.saveAll(claimStatuses);
	        }else{
	        	throw new RuntimeException("Invalid Year");}
    	}else {
    		throw new RuntimeException("Invalid Month");
    	}
}
    private boolean isValidYear(int year) {
//    	Integer year1 = year;
//    	if(year1.getClass() == Integer.TYPE) {
//    		String pattern = "\\d{4}";
//    		return Pattern.matches(pattern, String.valueOf(year));}
//    	else {
//    		return false;
//    	}
    	return true;
    }
}
