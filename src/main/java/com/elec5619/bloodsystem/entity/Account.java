package com.elec5619.bloodsystem.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity (name = "Account") // for hibernate
@Table (name = "Account",
        // specify the name of constraints
        uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)   // for table
public class Account {

    @Id
    // these two annotations are for auto-generated PK
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition ="Text"
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition ="Text"
//            ,unique = true
    )
    private String email;

    @Column(
            name = "dob",
            nullable = false,
            columnDefinition ="Text"
    )
    private LocalDate dob;

    // age can be calculated from date of birth, change `get` method
    // this will not be in the database anymore
    @Transient
    private Integer age;

    public Account() {

    }

    public Account(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
