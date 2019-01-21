package com.vivek.spring.cloudfunction.aws.service;

import com.vivek.spring.cloudfunction.aws.domain.Data;
import com.vivek.spring.cloudfunction.aws.repo.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UppercaseService {

    @Autowired
    private DataRepo dataRepo;
    public String uppercase(final String input) {
        dataRepo.save(new Data(input,input.toUpperCase()));
        return input.toUpperCase(Locale.ENGLISH);
    }
}
