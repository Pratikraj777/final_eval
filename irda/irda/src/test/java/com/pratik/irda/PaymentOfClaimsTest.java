package com.pratik.irda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pratik.irda.entities.PaymentOfClaims;
import com.pratik.irda.repo.PaymentOfClaimsRepo;
import com.pratik.irda.service.PaymentOfClaimsService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentOfClaimsTest {

    @Mock
    private PaymentOfClaimsRepo paymentOfClaimsRepo;

    @InjectMocks
    private PaymentOfClaimsService paymentOfClaimsService;

    @Test
    public void testGetPaymentOfClaimsWithValidData() {
        String month = "May";
        int year = 2023;
        PaymentOfClaims paymentOfClaims = new PaymentOfClaims(3,3000,"May", 2023);
        
        // Set up mock behavior
        when(paymentOfClaimsRepo.findPaymentOfClaimsByMonthAndYear(month, year)).thenReturn(paymentOfClaims);

        // Call the method under test
        PaymentOfClaims result = paymentOfClaimsService.getPaymentOfClaims(month, year);

        // Verify the result
        assertEquals(paymentOfClaims, result);
        verify(paymentOfClaimsRepo).findPaymentOfClaimsByMonthAndYear(month, year);
    }

    @Test
    public void testGetPaymentOfClaimsWithInvalidData() {
        String month = "May";
        int year = 2023;

        // Set up mock behavior
        when(paymentOfClaimsRepo.findPaymentOfClaimsByMonthAndYear(month, year)).thenReturn(null);

        // Call the method under test and assert an exception is thrown
        assertThrows(RuntimeException.class, () -> paymentOfClaimsService.getPaymentOfClaims(month, year));

        verify(paymentOfClaimsRepo).findPaymentOfClaimsByMonthAndYear(month, year);
    }
    
    @Test
    public void testGetPaymentOfClaimsWithWrongData(){
    	int month = 123;
    	String year = "hello";
    	
    }
}
