package com.swedbank.academy.demoserver.country;


import com.swedbank.academy.demoserver.person.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = {"country_name", "country_code"}))
public class Country {


    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @SequenceGenerator(name = "country_generator", sequenceName = "country_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_generator")
    private long id;

    @NonNull
    @Column(name = "country_name")
    private String countryName;

    @NonNull
    @Column(name = "country_code")
    private String countryCode;

   // @OneToMany
   // @JoinColumn(name="country_id")
   // private Set<Person> personSet;

    // @OneToMany(targetEntity=Person.class, mappedBy="country",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<Person> user = new ArrayList<>();


}
