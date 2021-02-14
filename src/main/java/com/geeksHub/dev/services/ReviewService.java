package com.geeksHub.dev.services;

import com.geeksHub.dev.entities.Company;
import com.geeksHub.dev.entities.Review;
import com.geeksHub.dev.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    CompanyRepository companyRepository;

    public void updateRating(String companyId) {
        int avg = 0;
        Company company = companyRepository.findById(companyId).get();
        for(Review review: company.reviews) {
            avg += review.rating;
        }
        company.rating =  avg / company.reviews.size();
        companyRepository.save(company);
    }
}
