package com.swedbank.academy.demoserver.country;

import com.swedbank.academy.demoserver.group.Group;

import java.util.List;

public interface CountryService {
    public List<Country> getAll();
    public Country getById(long id);
    public void save(Country country);
    public void update(Country country);
    public void saveAndFlush(Country country);
    public void delete(long id);

}
