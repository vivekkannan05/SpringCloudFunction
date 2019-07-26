package com.vivek.spring.cloudfunction.aws.service;

import com.vivek.spring.cloudfunction.aws.domain.Data;
import com.vivek.spring.cloudfunction.aws.repo.DataRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UppercaseServiceTest {

    @Mock DataRepo datarepo;

    @InjectMocks UppercaseService uppercaseService;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void uppercaseScenario1() {
        Mockito.when(datarepo.save(ArgumentMatchers.isA(Data.class))).thenReturn(new Data());
        assertEquals("WELCOME TO MYWORLD", uppercaseService.uppercase("welcome to myworld"));
    }

    @Test public void uppercaseScenario2() {
        Mockito.when(datarepo.save(ArgumentMatchers.isA(Data.class))).thenReturn(new Data());
        assertEquals("HOW ARE YOU?", uppercaseService.uppercase("how are you?"));
    }

    @Test(expected = NullPointerException.class) public void uppercaseScenario3() {
        Mockito.when(datarepo.save(ArgumentMatchers.isA(Data.class))).thenReturn(new Data());
        assertNull(uppercaseService.uppercase(null));
    }
}
