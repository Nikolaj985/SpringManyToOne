package com.swedbank.academy.demoserver.country;

import java.util.List;

public interface CountryService {
    public List<Country> getAll();
    public Country getById(long id);
}
