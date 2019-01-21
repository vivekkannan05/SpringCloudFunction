package com.vivek.spring.cloudfunction.aws.repo;

import com.vivek.spring.cloudfunction.aws.domain.Data;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DataRepo extends CrudRepository<Data, String> {

}
