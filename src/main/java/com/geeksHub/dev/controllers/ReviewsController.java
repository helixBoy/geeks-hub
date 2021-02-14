package com.geeksHub.dev.controllers;

import com.geeksHub.dev.dtos.ReviewDto;
import com.geeksHub.dev.entities.Company;
import com.geeksHub.dev.entities.Review;
import com.geeksHub.dev.entities.User;
import com.geeksHub.dev.repositories.CompanyRepository;
import com.geeksHub.dev.repositories.UserRepository;
import com.geeksHub.dev.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public Map<String, List<ReviewDto>> getReviewsByCompanyId(@PathVariable("id") String id) {
        Map response = new HashMap<String, List<ReviewDto>>();
        response.put("data", this.companyRepository.findById(id).get().reviews);
        return response;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public void update(@RequestBody ReviewDto reviewDto){
        User user = userRepository.findById(reviewDto.userId).get();
        Company existingCompany = this.companyRepository.findById(reviewDto.companyId).get();
        existingCompany.reviews.add(new Review(reviewDto.body, new Date(), reviewDto.rating, user));
        existingCompany.rating = this.companyService.updateRating(reviewDto.companyId, reviewDto.rating);
        this.companyRepository.save(existingCompany);
    }
}