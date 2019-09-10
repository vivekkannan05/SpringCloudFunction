package com.vivek.spring.cloudfunction.aws.service;

import com.vivek.spring.cloudfunction.aws.domain.Data;
import com.vivek.spring.cloudfunction.aws.repo.DataRepo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UppercaseService {

    private final DataRepo dataRepo;

    @Autowired public UppercaseService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public String uppercase(final String input) {

        dataRepo.save(new Data(input, input.toUpperCase()));
        return input.toUpperCase(Locale.ENGLISH);
    }
}
