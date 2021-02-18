package com.swedbank.academy.demoserver.country;

import com.swedbank.academy.demoserver.country.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {

        List<Country> countries = countryRepository.findAll();
        return countries;
    }

    @Override
    public Country getById(long id) {
        return countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException(id));
    }
}
