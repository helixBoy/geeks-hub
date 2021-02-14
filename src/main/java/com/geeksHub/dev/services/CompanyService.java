package com.geeksHub.dev.services;

import com.geeksHub.dev.entities.Company;
import com.geeksHub.dev.entities.Review;
import com.geeksHub.dev.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public double updateRating(String companyId, double newRating) {
        double avg = newRating;
        Company company = companyRepository.findById(companyId).get();
        for(Review review: company.reviews) {
            avg += review.rating;
        }
        return avg / company.reviews.size();
    }
}
