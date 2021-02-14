package com.geeksHub.dev.repositories;

import com.geeksHub.dev.dtos.CompaniesDto;
import com.geeksHub.dev.entities.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    @Query(value = "{}", fields="{'name':1, '_id':0}")
    List<CompaniesDto> getAllCompaniesNames();

}