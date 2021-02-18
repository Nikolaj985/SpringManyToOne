package com.swedbank.academy.demoserver.country;


import com.swedbank.academy.demoserver.person.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "country")
public class Country {


    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @SequenceGenerator(name = "country_generator", sequenceName = "country_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_generator")
    private long id;

    @NonNull
    @Column(name = "country_name")
    private  String countryName;

    @NonNull
    @Column(name = "country_code")
    private  String countryCode;


    //@OneToMany(mappedBy="country")
    //private Set<Person> persons;


}
