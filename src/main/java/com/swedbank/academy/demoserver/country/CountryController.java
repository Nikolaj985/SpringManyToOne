package com.swedbank.academy.demoserver.country;


import com.swedbank.academy.demoserver.group.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Country>> getCountry() {
        List<Country> list = countryService.getAll();
        return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> getById(@PathVariable("id") long id) {
        Country country = countryService.getById(id);
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }


}
