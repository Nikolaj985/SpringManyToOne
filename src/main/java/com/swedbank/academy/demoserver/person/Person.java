package com.swedbank.academy.demoserver.person;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.swedbank.academy.demoserver.country.Country;
import com.swedbank.academy.demoserver.group.Group;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @NotNull
    private long pid;

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String name;

    @NotNull
    @Column(name = "middle_name")
    private String middlename;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastname;
    private String email;
    private String phone;


    @ManyToOne()
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "person_group", joinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Group> groups;

}
