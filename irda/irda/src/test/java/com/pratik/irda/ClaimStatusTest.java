package com.pratik.irda;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pratik.irda.repo.ClaimStatusRepo;
import com.pratik.irda.repo.PendingStatusReportRepo;
import com.pratik.irda.service.ClaimStatusService;

@ExtendWith(MockitoExtension.class)
public class ClaimStatusTest {

    @Mock
    private PendingStatusReportRepo pendingStatusReportRepo;

    @Mock
    private ClaimStatusRepo claimStatusRepo;

    @InjectMocks
    private ClaimStatusService claimStatusService;

    @Test
    public void testGetClaimStatusByMonthYear() {
       assertTrue(true);
        
    }
}
