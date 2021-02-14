package com.geeksHub.dev.controllers;

import com.geeksHub.dev.dtos.CompaniesDto;
import com.geeksHub.dev.entities.Company;
import com.geeksHub.dev.repositories.CompanyRepository;
import com.geeksHub.dev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public Map<String, List<CompaniesDto>> getAll() {
        Map response = new HashMap<String, List<CompaniesDto>>();
        response.put("data", this.companyRepository.getAllCompaniesNames());
        return response;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public void insert(@RequestBody Company company){
        this.companyRepository.insert(company);
    }

//    @PutMapping
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//    public void update(@RequestBody ReviewDto companyReviews){
//        Company existingCompany = this.companyRepository.findById(companyReviews.company_id).get();
//        for (Review review : companyReviews.reviews ){
////            review.user = userRepository.findById()
//            existingCompany.reviews.add(review);
//        }
//
//        this.companyRepository.save(existingCompany);
//    }


//    @GetMapping("/{id}")
//    public Hotel getById(@PathVariable("id") String id){
//        Hotel hotel = this.hotelRepository.findById(id);
//
//        return hotel;
//    }
//
//    @GetMapping("/price/{maxPrice}")
//    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
//        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
//
//        return hotels;
//    }
//
//    @GetMapping("/address/{city}")
//    public List<Hotel> getByCity(@PathVariable("city") String city){
//        List<Hotel> hotels = this.hotelRepository.findByCity(city);
//
//        return hotels;
//    }
//
//    @GetMapping("/country/{country}")
//    public List<Hotel> getByCountry(@PathVariable("country") String country){
//        // create a query class (QHotel)
//        QHotel qHotel = new QHotel("hotel");
//
//        // using the query class we can create the filters
//        BooleanExpression filterByCountry = qHotel.address.country.eq(country);
//
//        // we can then pass the filters to the findAll() method
//        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByCountry);
//
//        return hotels;
//    }
//
//    @GetMapping("/recommended")
//    public List<Hotel> getRecommended(){
//        final int maxPrice = 100;
//        final int minRating = 7;
//
//        // create a query class (QHotel)
//        QHotel qHotel = new QHotel("hotel");
//
//        // using the query class we can create the filters
//        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
//        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);
//
//        // we can then pass the filters to the findAll() method
//        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByPrice.and(filterByRating));
//
//        return hotels;
//    }


}
