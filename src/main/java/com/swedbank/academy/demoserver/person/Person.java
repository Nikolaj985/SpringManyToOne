package com.swedbank.academy.demoserver.person;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Table(name="person")
public class Person {
    @Id
    @NotNull
    private long pid;

    @NotNull
    @NotBlank
    @Column(name="first_name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name="middle_name")
    private String middlename;

    @NotNull
    @NotBlank
    @Column(name="last_name")
    private String lastname;
    private String email;
    private String phone;

}
